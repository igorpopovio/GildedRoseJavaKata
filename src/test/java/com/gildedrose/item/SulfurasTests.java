package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.LessRestrictiveItemContractTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTests extends LessRestrictiveItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Sulfuras, Hand of Ragnaros";
    }

    @Test
    public void doesNotDecreaseInQualityEachDayBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(20, item.quality);
    }

    @Test
    public void doesNotDecreaseInQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 20);

        item = updateQualityFor(item);

        assertEquals(20, item.quality);
    }
}
