package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import junitparams.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Normal Item";
    }

    @Test
    @Parameters({
            "10, 20, 19, decreases in quality each day before expiration",
            "10,  0,  0, doesn't decrease to negative quality before expiration",
            "-1,  0,  0, doesn't decrease to negative quality after expiration",

            // FIXME: comment to drop the mutation coverage while keeping 100% branch coverage
            " 0,  2,  0, quality degrades twice as fast after expiration",
            " 1,  2,  1, quality degrades normally 1 day before expiration",
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
}
