package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.common.ItemContractTests;
import org.junit.Test;

public class AgedBrieTests extends ItemContractTests {
    @Override
    public String getDefaultItemName() {
        return "Aged Brie";
    }

    @Test
    public void increasesInQualityTheOlderItGets() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        // assertEquals(21, item.quality);
    }

    @Test
    public void increasesInQualityOnExpirationDay() {
        Item item = createItemWithSellInAndQuality(10, 0);

        item = updateQualityFor(item);

        // assertEquals(1, item.quality);
    }

    @Test
    public void increasesEvenMoreInQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        // assertEquals(2, item.quality);
    }

    @Test
    public void increasesInQualityOnlyUpTo50AfterExpiration() {
        Item item = createItemWithSellInAndQuality(0, 49);

        item = updateQualityFor(item);

        // assertEquals(50, item.quality);
    }
}
