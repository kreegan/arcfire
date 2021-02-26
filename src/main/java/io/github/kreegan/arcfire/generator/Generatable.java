package io.github.kreegan.arcfire.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Interface for objects that can be generated
 */
public interface Generatable<T> {

    Logger logger = LoggerFactory.getLogger(Generatable.class);

    /**
     * Generate method that is called by a RandomGenerator. In most cases will act as a pass thru generateReflectively, but
     * that behavior can also be overridden when needed
     *
     * @param parameters parameter map to populate the Generatable from
     */
    void generateOverride(Map<String, Object> parameters);

    /**
     * Reflection based generate method that takes a parameters map and populates the Generatable based on the contents
     *
     * @param parameters parameter map to populate the Generatable from
     * @param instance   Generatable instance
     */
    default void generateReflectively(Map<String, Object> parameters, T instance) {

        for (Field field : instance.getClass().getDeclaredFields()) {
            String fieldName = field.getName();
            if (parameters != null && parameters.containsKey(fieldName)) {
                try {
                    String firstCharacter = fieldName.substring(0, 1);
                    String accessorMethod = "set" + fieldName.replaceFirst(firstCharacter, firstCharacter.toUpperCase());
                    Method accessor = ReflectionUtils.findMethod(instance.getClass(), accessorMethod, null);
                    accessor.invoke(instance, parameters.get(fieldName));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Unable to reflectively set field: " + fieldName, e);
                }
            }
        }
    }
}
