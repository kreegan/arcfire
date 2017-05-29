package io.github.kreegan.arcfire.generator;

import io.github.kreegan.arcfire.model.Gender;
import io.github.kreegan.arcfire.model.NPC;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for RandomGenerator
 */
public class RandomGeneratorTest {

    @Test
    public void generateWithParams_happyPath() {

        RandomGenerator<NPC> npcRandomGenerator = new RandomGenerator<>();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", "Testy McTester");
        parameters.put("race", "Test Monkey");
        parameters.put("gender", Gender.OTHER);
        parameters.put("description", "Test 123");
        parameters.put("profession", "Tester");
        // Unit under test
        NPC npc = npcRandomGenerator.generateWithParams(parameters, NPC.class);

        assertNotNull(npc);
        assertNotNull(npc.getDescription());
        assertNotNull(npc.getGender());
        assertNotNull(npc.getName());
        assertNotNull(npc.getProfession());
        assertNotNull(npc.getRace());
    }
}