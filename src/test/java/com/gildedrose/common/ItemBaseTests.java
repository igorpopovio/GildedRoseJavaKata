package com.gildedrose.common;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public abstract class ItemBaseTests {
    public int getDefaultItemQuality() {
        return 10;
    }

    public abstract String getDefaultItemName();

    public Item createItemWithSellIn(int sellIn) {
        return new Item(getDefaultItemName(), sellIn, getDefaultItemQuality());
    }

    public Item createItemWithSellInAndQuality(int sellIn, int quality) {
        return new Item(getDefaultItemName(), sellIn, quality);
    }

    public Item updateQualityFor(Item item) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return item;
    }
}
