package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public abstract class LessRestrictiveItemContractTests extends ItemBaseTests {
    @Test
    public void qualityCannotBeNegativeEvenAfterExpiration() throws Exception {
        Item item = createItemWithSellInAndQuality(0, 0);

        item = updateQualityFor(item);

        assertTrue(item.quality >= 0);
    }

    @Test
    public void qualityCannotBeMoreThan50() throws Exception {
        Item item = createItemWithSellInAndQuality(10, 50);

        item = updateQualityFor(item);

        assertTrue(item.quality <= 50);
    }

    @Test
    @Ignore("TODO: Should fail, but doesn't. Fix later!")
    public void cannotBeCreatedWithNegativeQuality() {
        createItemWithSellInAndQuality(10, -1);
    }

    @Test
    @Ignore("TODO: Should fail, but doesn't. Fix later!")
    public void cannotBeCreatedWithQualityMoreThan50() throws Exception {
        createItemWithSellInAndQuality(10, 51);
    }
}
