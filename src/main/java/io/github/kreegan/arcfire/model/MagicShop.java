package io.github.kreegan.arcfire.model;

import io.github.kreegan.arcfire.generator.Generatable;

import java.util.List;
import java.util.Map;

/**
 * Object representing a magic shop with inventory and proprietor(s)
 */
public class MagicShop implements Generatable<MagicShop> {

    private List<InventoryItem> inventory;
    private List<NPC> proprietors;

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

    @Override
    public void generateOverride(Map<String, Object> parameters) {
        generateInternal(parameters, this);
    }
}
