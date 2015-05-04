package com.gildedrose.common;

import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class ItemContractTests extends LessRestrictiveItemContractTests {
    @Test
    public void sellInDecreasesEachDayEvenAfterExpiration() throws Exception {
        Item item = createItemWithSellIn(0);

        item = updateQualityFor(item);

        assertEquals(-1, item.sellIn);
    }
}
