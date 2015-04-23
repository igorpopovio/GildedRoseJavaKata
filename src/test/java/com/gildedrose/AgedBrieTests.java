package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTests extends ItemContractTests {
    public static String DEFAULT_ITEM_NAME = "Aged Brie";
    public static int DEFAULT_ITEM_QUALITY = 10;

    @Override
    public Item createItemWithSellIn(int sellIn) {
        return new Item(DEFAULT_ITEM_NAME, sellIn, DEFAULT_ITEM_QUALITY);
    }

    @Override
    public Item createItemWithSellInAndQuality(int sellIn, int quality) {
        return new Item(DEFAULT_ITEM_NAME, sellIn, quality);
    }

    @Test
    public void increasesInQualityTheOlderItGets() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(21, item.quality);
    }

    @Test
    public void increasesInQualityOnExpirationDay() {
        Item item = createItemWithSellInAndQuality(10, 0);

        item = updateQualityFor(item);

        assertEquals(1, item.quality);
    }

    @Test
    public void increasesEvenMoreInQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        assertEquals(2, item.quality);
    }
}
