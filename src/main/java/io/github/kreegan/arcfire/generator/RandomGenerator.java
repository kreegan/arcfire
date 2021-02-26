package io.github.kreegan.arcfire.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Class that randomly generates an object that implements the Generatable interface
 */
public class RandomGenerator<T extends Generatable> {
    Logger logger = LoggerFactory.getLogger(RandomGenerator.class);

    public <T extends Generatable> T generateWithParams(Map<String, Object> parameters, Class<T> generatedClass) {

        try {
            T generated = generatedClass.newInstance();
            generated.generateOverride(parameters);
            return generated;
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
