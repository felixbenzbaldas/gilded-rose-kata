package com.gildedrose;

import java.util.List;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static public void nextDay(List<Item> items) {
        for (Item item : items) {
            item.nextDay();
        }
    }

    void nextDay() {
        sellIn--;
        boolean isAgedBrie = name.equals("Aged Brie");
        boolean isBackstagePass = name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");
        boolean isConjured = name.equals("conjured");
        if (isAgedBrie) {
            if (sellIn < 0) {
                increaseQuality_max50(2);
            } else {
                increaseQuality_max50(1);
            }
        } else if (isBackstagePass) {
            if (sellIn > 9) {
                increaseQuality_max50(1);
            } else if(sellIn > 4) {
                increaseQuality_max50(2);
            } else if(sellIn > -1) {
                increaseQuality_max50(3);
            } else {
                quality = 0;
            }
        } else if (isSulfuras) {
            // quality stays the same
        } else if (isConjured) {
            if (sellIn < 0) {
                decreaseQuality(4);
            } else {
                decreaseQuality(2);
            }
        } else {
            if (sellIn < 0) {
                decreaseQuality(2);
            } else {
                decreaseQuality(1);
            }
        }
    }

    private void decreaseQuality(int change) {
        quality = Math.max(quality - change, 0);
    }

    private void increaseQuality_max50(int change) {
        quality = Math.min(quality + change, 50);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
