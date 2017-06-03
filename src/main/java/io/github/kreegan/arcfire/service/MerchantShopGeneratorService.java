package io.github.kreegan.arcfire.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.kreegan.arcfire.generator.RandomGenerator;
import io.github.kreegan.arcfire.model.MerchantShop;
import io.github.kreegan.arcfire.util.JSONUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Service to handle merchant shop generation
 */
@Component
public class MerchantShopGeneratorService {

    public static final String ADVENTURING_GEAR_FILE = "resources/static/adventuring_gear.json";
    public static final String ARMOR_FILE = "resources/static/armor.json";
    public static final String TOOLS_FILE = "resources/static/tools.json";
    public static final String WEAPONS_FILE = "resources/static/weapons.json";

    public MerchantShop generateMerchantShop(Boolean hasMagicItems) {

        RandomGenerator<MerchantShop> merchantShopRandomGenerator = new RandomGenerator<>();
        JsonNode advGearNode = JSONUtil.readFromFile(ADVENTURING_GEAR_FILE);
        JsonNode armorNode = JSONUtil.readFromFile(ARMOR_FILE);
        JsonNode toolsNode = JSONUtil.readFromFile(TOOLS_FILE);
        JsonNode weaponsNode = JSONUtil.readFromFile(WEAPONS_FILE);
        if(hasMagicItems) {
            // TODO add magic item functionality, likely not just one file but multiple
        }
        Map<String, Object> parameters = buildParameters(advGearNode, armorNode, toolsNode, weaponsNode);
        MerchantShop merchantShop = merchantShopRandomGenerator.generateWithParams(parameters, MerchantShop.class);

        return merchantShop;
    }

    private Map<String, Object> buildParameters(JsonNode... seedData) {
        return null;
    }
}
