package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Aged Brie";
    }

    @Test
    public void increasesInQualityOnExpirationDay() {
        Item item = createItemWithSellInAndQuality(10, 0);

        item = updateQualityFor(item);

        assertEquals(1, item.quality);
    }
}
