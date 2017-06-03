package io.github.kreegan.arcfire.model;

import io.github.kreegan.arcfire.generator.Generatable;

import java.util.List;
import java.util.Map;

/**
 * Object representing a merchant shop with inventory and proprietor(s)
 */
public class MerchantShop implements Generatable<MerchantShop> {

    private List<InventoryItem> inventory;
    private List<NPC> proprietors;
    private Boolean hasMagicItems;

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public List<NPC> getProprietors() {
        return proprietors;
    }

    public void setProprietors(List<NPC> proprietors) {
        this.proprietors = proprietors;
    }

    public Boolean getHasMagicItems() {
        return hasMagicItems;
    }

    public void setHasMagicItems(Boolean hasMagicItems) {
        this.hasMagicItems = hasMagicItems;
    }

    @Override
    public void generateOverride(Map<String, Object> parameters) {
        generateReflectively(parameters, this);
    }
}
