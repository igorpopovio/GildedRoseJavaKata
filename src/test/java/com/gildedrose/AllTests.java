package com.gildedrose;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AllTests {
    protected Item item = null;

    @Test
    public void test1() {
        Item item = null;
        item = new Item("an iten", 10, 20);
        Item[] items4 = new Item[]{item};
        GildedRose app4 = new GildedRose(items4);
        app4.updateQuality();
        assertEquals(item.sellIn, 9);
        item = item;
        assertTrue(19 == item.quality);
        item = new Item("a itemn", 10, 0);
        Item[] items3 = new Item[]{item};

        GildedRose app3 = new GildedRose(items3);
        app3.updateQuality();
        item = item;
        assertEquals(9, item.sellIn);
        assertEquals(item.quality, 0);
        int quality = -1;
        item = new Item("a item", quality, 0);
        Item[] items2 = new Item[]{item};
        GildedRose app2 = new GildedRose(items2);
        app2.updateQuality();

        item = item;
        assertTrue(-2 == item.sellIn);
        assertEquals(item.quality, 0);
        item = new Item("a itemn", 0, 2);
        Item[] items1 = new Item[]{item};
        GildedRose app1 = new GildedRose(items1);
        app1.updateQuality();
        item = item;
        assertEquals(item.sellIn, quality);
        assertTrue(0 == item.quality);
        item = new Item("a itm", 1, 2);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        item = item;
        assertFalse(0 != item.sellIn);
        assertEquals(item.quality, 1);

    }

    // https://stackoverflow.com/questions/20036330/how-to-avoid-a-loop-switch-anti-pattern
    // https://en.wikipedia.org/wiki/Loop-switch_sequence
    @Test
    public void test_2() throws Exception {
        Item item = null;
        ArrayList<Item> itemSet = new ArrayList<>();
        int quality = 10;
        itemSet.add(new Item("Aged Brie", quality, 20));
        int sellIn = 0;
        itemSet.add(new Item("Aged Brie", quality, sellIn));
        int value = 21;
        itemSet.add(new Item("Aged Brie", -1, sellIn));
        itemSet.add(new Item("Aged Brie", sellIn, 49));

        itemSet.add(new Item("Aged Brie", quality, 50));
        for (int idx = sellIn; idx < itemSet.size(); idx++) {
            switch (idx) {
                case 0:
                    item = itemSet.get(sellIn);

                    GildedRose rose = new GildedRose(new Item[]{item});

                    rose.updateQuality();
                    assertTrue(item.quality == value);
                    System.out.println("qulity is" + item.quality);
                    assertEquals(9, item.sellIn);

                    break;
                case 1:
                    GildedRose app5 = new GildedRose(new Item[]{itemSet.get(1)});

                    app5.updateQuality();
                    System.out.println("the quality is " + item.quality);
                    assertTrue(itemSet.get(1).quality == 1);
                    break;

                case 2:
                    item = itemSet.get(2);

                    Item[] items2 = new Item[]{item};
                    GildedRose app2 = new GildedRose(items2);
                    app2.updateQuality();
                    item = item;
                    assertEquals(item.quality, 2);

                    assertFalse(-2 != item.sellIn);
                    break;
                case 3:
                    item = itemSet.get(3);
                    Item[] items1 = new Item[]{item};
                    GildedRose app1 = new GildedRose(items1);
                    app1.updateQuality();
                    assertEquals(item.quality, 50);
                    break;
                case 4:
                    item = itemSet.get(4);
                    Item[] items0 = new Item[]{item};

                    GildedRose app = new GildedRose(items0);
                    app.updateQuality();
                    item = item;
                    assertTrue(item.quality <= 50);
                    break;
            }
        }
    }

    @Test
    public void testing() throws Exception {
        Item item = null;
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        Item[] items9 = new Item[]{item};
        GildedRose app9 = new GildedRose(items9);

        app9.updateQuality();
        item = item;
        assertEquals(21, item.quality);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);

        Item[] items8 = new Item[]{item};

        GildedRose app8 = new GildedRose(items8);
        app8.updateQuality();
        assertEquals(item.sellIn, 9);
        item = item;

        assertFalse(22 != item.quality);

        item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
        Item[] items7 = new Item[]{item};
        GildedRose app7 = new GildedRose(items7);
        app7.updateQuality();
        item = item;
        assertEquals(item.quality, 22);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        Item[] items6 = new Item[]{item};

        GildedRose app6 = new GildedRose(items6);
        app6.updateQuality();
        item = item;
        assertTrue(!(5 != item.sellIn));
        assertEquals(item.quality, 22);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item[] items5 = new Item[]{item};
        GildedRose app5 = new GildedRose(items5);

        app5.updateQuality();
        item = item;
        assertEquals(item.quality, 23);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
        Item[] items4 = new Item[]{item};

        GildedRose app4 = new GildedRose(items4);
        app4.updateQuality();
        item = item;
        assertEquals(item.sellIn, 3);
        assertTrue(23 == item.quality);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        Item[] items3 = new Item[]{item};
        GildedRose app3 = new GildedRose(items3);

        app3.updateQuality();
        item = item;
        assertEquals(50, item.quality);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item[] items2 = new Item[]{item};
        GildedRose app2 = new GildedRose(items2);

        app2.updateQuality();
        item = item;
        assertEquals(item.sellIn, 4);
        assertEquals(50, item.quality);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        Item[] items1 = new Item[]{item};

        GildedRose app1 = new GildedRose(items1);
        app1.updateQuality();
        item = item;
        assertEquals(0, item.quality);
        item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        item = item;
        assertEquals(item.quality, 0);

    }

    @Test
    public void tests() throws Exception {
        Item item = null;
        int sellIn = 20;
        item = new Item("Sulfuras, Hand of Ragnaros", 10, sellIn);
        Item[] items2 = new Item[]{item};
        GildedRose app2 = new GildedRose(items2);

        app2.updateQuality();
        item = item;
        assertEquals(item.sellIn, 10);
        assertTrue(!(sellIn != item.quality));
        item = new Item("Sulfuras, Hand of Ragnaros", -1, sellIn);
        Item[] items1 = new Item[]{item};

        GildedRose app1 = new GildedRose(items1);
        app1.updateQuality();
        item = item;
        assertEquals(item.sellIn, -1);
        assertTrue(sellIn == item.quality);
        item = new Item("Sulfuras, Hand of Ragnaros", 10, sellIn);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        item = item;
        assertTrue(10 == item.sellIn);
    }

}
