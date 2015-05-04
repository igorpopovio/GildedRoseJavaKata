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
    public void decreasesInQualityEachDayBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 20);

        item = updateQualityFor(item);

        assertEquals(19, item.quality);
    }

    @Test
    public void doesNotDecreaseToNegativeQualityBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(10, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }

    @Test
    public void doesNotDecreaseToNegativeQualityAfterExpiration() {
        Item item = createItemWithSellInAndQuality(-1, 0);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }

    // FIXME: comment test to drop the mutation test coverage while keeping branch coverage to 100%
    @Test
    public void qualityDegradesTwiceAsFastAfterExpiration() {
        Item item = createItemWithSellInAndQuality(0, 2);

        item = updateQualityFor(item);

        assertEquals(0, item.quality);
    }

    // FIXME: comment test to drop the mutation test coverage while keeping branch coverage to 100%
    @Test
    public void qualityDegradesNormally1DayBeforeExpiration() {
        Item item = createItemWithSellInAndQuality(1, 2);

        item = updateQualityFor(item);

        assertEquals(1, item.quality);
    }
}
