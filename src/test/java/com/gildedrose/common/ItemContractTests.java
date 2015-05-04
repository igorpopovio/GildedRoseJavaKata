package com.gildedrose.common;

import com.gildedrose.Item;
import junitparams.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class ItemContractTests extends LessRestrictiveItemContractTests {
    @Test
    @Parameters({
            "10,  9, sell in decreases each day",
            " 0, -1, sell in decreases each day even after expiration",
    })
    public void sellInUpdatesCorrectly(
            int initialSellIn,
            int expectedSellIn,
            String message) {
        Item item = createItemWithSellIn(initialSellIn);

        item = updateQualityFor(item);

        assertEquals(message, expectedSellIn, item.sellIn);
    }
}
