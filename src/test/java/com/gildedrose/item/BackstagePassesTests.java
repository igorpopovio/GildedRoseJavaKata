package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
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

    @Test
    public void increasesWith2InQuality6DaysBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(6, 20);

        item = updateQualityFor(item);

        assertEquals(22, item.quality);
    }

    @Test
    public void increasesWith3InQuality5DaysBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(5, 20);

        item = updateQualityFor(item);

        assertEquals(23, item.quality);
    }

    @Test
    public void increasesWith3InQuality4DaysBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(4, 20);

        item = updateQualityFor(item);

        assertEquals(23, item.quality);
    }

    @Test
    public void qualityDropsToZeroOnExpirationDay() {
        Item item = createItemWithSellInAndQuality(0, 20);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }

    @Test
    public void qualityStaysZeroAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }
}
