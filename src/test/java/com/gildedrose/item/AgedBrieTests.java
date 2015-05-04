package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import junitparams.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Aged Brie";
    }

    @Test
    @Parameters({
            "10, 20, 21, increases in quality the older it gets",
            "10,  0,  1, increases in quality on the expiration day",
            "-1,  0,  2, increases even more in quality after expiration",
            " 0, 49, 50, increases in quality only up to 50 after expiration",
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
