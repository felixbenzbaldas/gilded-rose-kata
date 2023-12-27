package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    void qualityOfConjuredItemsDecreasesByTwo() {
        Item conjuredItem = new Item("conjured", 10, 20);
        Item[] items = new Item[]{
            conjuredItem
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(conjuredItem.quality).isEqualTo(18);
    }

    @Test
    void qualityDoesNotBecomeNegative() {
        Item conjuredItem = new Item("conjured", 10, 0);
        Item[] items = new Item[]{
            conjuredItem
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(conjuredItem.quality).isEqualTo(0);
    }

    @Test
    void qualityOfConjuredItemsAfterSellByDate() {
        Item conjuredItem = new Item("conjured", 0, 10);
        Item[] items = new Item[]{
            conjuredItem
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(conjuredItem.quality).isEqualTo(6);
    }
}
