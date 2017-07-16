package io.github.kreegan.arcfire.model;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void generateDwarfClanNames() {
        List<String> prefixes = Arrays.asList(
                "Stone",
                "Steel",
                "Iron",
                "Dark",
                "Fire",
                "Crag",
                "Storm",
                "Thunder",
                "Mead",
                "Molten",
                "Mountain",
                "Orc",
                "Red",
                "Gray",
                "Silver",
                "Black",
                "Rock",
                "Rune",
                "Stout",
                "Strong",
                "Battle",
                "Grim",
                "Horn",
                "Ice",
                "Giant",
                "Dire",
                "Frost",
                "Burning",
                "Blood",
                "Cold",
                "Deep",
                "Grey",
                "Flint",
                "Swift",
                "Dour",
                "Earth",
                "Earthen",
                "Fleet",
                "Soot",
                "Coal",
                "Snow",
                "Copper",
                "Silver",
                "Pillar",
                "Anvil",
                "Gold",
                "Nether",
                "White"
                );
        List<String> suffixes = Arrays.asList(
                "mail",
                "stone",
                "forge",
                "born",
                "eye",
                "blade",
                "axe",
                "hammer",
                "bane",
                "breaker",
                "delve",
                "brew",
                "thew",
                "beard",
                "brow",
                "spike",
                "braid",
                "deep",
                "helm",
                "hew",
                "spine",
                "striker",
                "grip",
                "caller",
                "forged",
                "heart",
                "fist",
                "arm",
                "foot",
                "boot",
                "bellow",
                "brand",
                "fury",
                "rage",
                "foe",
                "tooth",
                "breath",
                "heel",
                "hand",
                "guide",
                "gate",
                "soul",
                "silver",
                "pillar",
                "gold",
                "pike",
                "pick",
                "mine",
                "miner",
                "warden"
                );

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 200; i++) {
            String name = prefixes.get(random.nextInt(prefixes.size())) + suffixes.get(random.nextInt(suffixes.size()));
            System.out.println(name);
        }
    }
}