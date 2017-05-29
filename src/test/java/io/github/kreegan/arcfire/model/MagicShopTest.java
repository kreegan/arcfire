package io.github.kreegan.arcfire.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for MagicShop
 */
public class MagicShopTest {

    @Test
    public void generateOverride_happyPath() {

        MagicShop magicShop = new MagicShop();
        Map<String, Object> parameters = new HashMap<>();
        List<InventoryItem> inventory = new ArrayList<>();
        List<NPC> proprietors = new ArrayList<>();
        parameters.put("inventory", inventory);
        parameters.put("proprietors", proprietors);

        // Unit under test
        magicShop.generateOverride(parameters);

        assertNotNull(magicShop.getInventory());
        assertNotNull(magicShop.getProprietors());
    }
}