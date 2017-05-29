package io.github.kreegan.arcfire.generator;

import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Class that randomly generates an object that implements the Generatable interface
 */
public class RandomGenerator<T extends Generatable> {

    private static final Logger LOGGER = Logger.getLogger(RandomGenerator.class);

    public <T extends Generatable> T generateWithParams(Map<String, Object> parameters, Class<T> generatedClass) {

        try {
            T generated = generatedClass.newInstance();
            generated.generateOverride(parameters);
            return generated;
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error(e);
        }

        return null;
    }
}
