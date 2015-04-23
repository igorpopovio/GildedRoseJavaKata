package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTests extends ItemContractTests {
    public static String DEFAULT_ITEM_NAME = "Normal Item";
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
    public void decreasesInQualityEachDayBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(19, item.quality);
    }

    @Test
    public void doesNotDecreaseToNegativeQualityBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }

    @Test
    public void doesNotDecreaseToNegativeQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }
}
