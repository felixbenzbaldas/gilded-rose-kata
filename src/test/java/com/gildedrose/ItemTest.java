package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ItemTest {

    @Test
    void qualityOfConjuredItemsDecreasesByTwo() {
        Item conjured = new Item("conjured", 10, 20);

        conjured.nextDay();

        assertThat(conjured.quality).isEqualTo(18);
    }

    @Test
    void qualityDoesNotBecomeNegative() {
        Item conjured = new Item("conjured", 10, 0);

        conjured.nextDay();

        assertThat(conjured.quality).isEqualTo(0);
    }

    @Test
    void qualityOfConjuredItemsAfterSellByDate() {
        Item conjured = new Item("conjured", 0, 10);

        conjured.nextDay();

        assertThat(conjured.quality).isEqualTo(6);
    }
}
