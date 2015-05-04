package com.gildedrose.common;

import org.junit.Ignore;
import org.junit.Test;

public abstract class LessRestrictiveItemContractTests extends ItemBaseTests {
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
