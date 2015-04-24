package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Test
    public void increasesInQualityTheOlderItGets() {
        Item item = createItemWithSellInAndQuality(11, 20);

        item = updateQualityFor(item);

        assertEquals(21, item.quality);
    }

    @Test
    public void increasesWith2InQuality10DaysBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(22, item.quality);
    }

    @Test
    public void increasesWith2InQuality9DaysBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(9, 20);

        item = updateQualityFor(item);

        assertEquals(22, item.quality);
    }
}
