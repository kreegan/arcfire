package io.github.kreegan.arcfire.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for MerchantShop
 */
public class MerchantShopTest {

    @Test
    public void generateOverride_happyPath() {

        MerchantShop merchantShop = new MerchantShop();
        Map<String, Object> parameters = new HashMap<>();
        List<InventoryItem> inventory = new ArrayList<>();
        List<NPC> proprietors = new ArrayList<>();
        parameters.put("inventory", inventory);
        parameters.put("proprietors", proprietors);
        parameters.put("hasMagicItems", Boolean.TRUE);

        // Unit under test
        merchantShop.generateOverride(parameters);

        assertNotNull(merchantShop.getInventory());
        assertNotNull(merchantShop.getProprietors());
        assertTrue(merchantShop.getHasMagicItems());
    }
}