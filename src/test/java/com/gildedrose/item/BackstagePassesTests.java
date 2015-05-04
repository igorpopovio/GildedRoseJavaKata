package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import junitparams.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Test
    @Parameters({
            "11, 20, 21, increases in quality the older it gets",
            "10, 20, 22, increases with 2 in quality 10 days before expiration",
            " 9, 20, 22, increases with 2 in quality  9 days before expiration",
            " 6, 20, 22, increases with 2 in quality  6 days before expiration",
            " 5, 20, 23, increases with 3 in quality  5 days before expiration",
            " 4, 20, 23, increases with 3 in quality  4 days before expiration",
            "10, 49, 50, increases up to 50 in quality 10 days before expiration",
            " 5, 49, 50, increases up to 50 in quality  5 days before expiration",
            " 0, 20,  0, quality drops to 0 on expiration day",
            "-1,  0,  0, quality stays 0 after expiration day",
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
