package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.LessRestrictiveItemContractTests;
import junitparams.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTests extends LessRestrictiveItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Sulfuras, Hand of Ragnaros";
    }

    @Test
    @Parameters({
            "10, 20, 20, doesn't decrease in quality each day before expiration",
            "-1, 20, 20, doesn't decrease in quality each day after expiration",
    })
    public void qualityUpdatesCorrectly(
            int sellIn,
            int initialQuality,
            int expectedQuality,
            String message) {
        Item item = createItemWithSellInAndQuality(sellIn, initialQuality);

        item = updateQualityFor(item);

        assertEquals(message, expectedQuality, item.quality);
    }

    // FIXME: comment to drop the mutation coverage while keeping 100% branch coverage
    @Test
    public void neverHasToBeSold() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(10, item.sellIn);
    }
}
