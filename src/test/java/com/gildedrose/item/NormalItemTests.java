package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Normal Item";
    }

    @Test
    public void doesNotDecreaseToNegativeQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }
}
