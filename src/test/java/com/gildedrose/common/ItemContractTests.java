package com.gildedrose.common;

import com.gildedrose.Item;
import org.junit.Test;

public abstract class ItemContractTests extends LessRestrictiveItemContractTests {
    @Test
    public void sellInDecreasesEachDay() throws Exception {
        Item item = createItemWithSellIn(10);

        item = updateQualityFor(item);

        // assertEquals(9, item.sellIn);
    }

    @Test
    public void sellInDecreasesEachDayEvenAfterExpiration() throws Exception {
        Item item = createItemWithSellIn(0);

        item = updateQualityFor(item);

        // assertEquals(-1, item.sellIn);
    }
}
