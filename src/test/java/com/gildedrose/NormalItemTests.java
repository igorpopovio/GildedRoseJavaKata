package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Normal Item";
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
