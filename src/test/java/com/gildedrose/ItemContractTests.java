package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ItemContractTests {
    @Test
    public void sellInDecreasesEachDay() throws Exception {
        Item item = createItemWithSellIn(10);

        item = updateQualityFor(item);

        assertEquals(9, item.sellIn);
    }

    @Test
    public void sellInDecreasesEachDayEvenAfterExpiration() throws Exception {
        Item item = createItemWithSellIn(0);

        item = updateQualityFor(item);

        assertEquals(-1, item.sellIn);
    }

    @Test
    public void qualityCannotBeNegativeEvenAfterExpiration() throws Exception {
        Item item = createItemWithSellInAndQuality(0, 0);

        item = updateQualityFor(item);

        assertTrue(item.quality >= 0);
    }

    @Test
    public void qualityCannotBeMoreThan50() throws Exception {
        Item item = createItemWithSellInAndQuality(10, 50);

        item = updateQualityFor(item);

        assertTrue(item.quality <= 50);
    }


    @Test
    @Ignore("TODO: Should fail, but doesn't. Fix later!")
    public void cannotBeCreatedWithNegativeQuality() {
        createItemWithSellInAndQuality(10, -1);
    }

    @Test
    @Ignore("TODO: Should fail, but doesn't. Fix later!")
    public void cannotBeCreatedWithQualityMoreThan50() throws Exception {
        createItemWithSellInAndQuality(10, 51);
    }

    public Item createItemWithSellIn(int sellIn) {
        return new Item(getDefaultItemName(), sellIn, getDefaultItemQuality());
    }


    public Item createItemWithSellInAndQuality(int sellIn, int quality) {
        return new Item(getDefaultItemName(), sellIn, quality);
    }

    public int getDefaultItemQuality() {
        return 10;
    }


    public abstract String getDefaultItemName();

    public Item updateQualityFor(Item item) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return item;
    }
}
