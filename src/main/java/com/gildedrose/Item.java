package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateItem() {
        boolean isAgedBrie = name.equals("Aged Brie");
        boolean isBackstagePass = name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");
        if (isAgedBrie) {
            if (quality < 50) {
                quality++;
            }
            sellIn = sellIn - 1;
            if (sellIn < 0) {
                if (quality < 50) {
                    quality++;
                }
            }
        } else if (isBackstagePass) {
            if (quality < 50) {
                quality++;
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality++;
                    }
                }
                if (sellIn < 6) {
                    if (quality < 50) {
                        quality++;
                    }
                }
            }
            sellIn--;
            if (sellIn < 0) {
                quality = 0;
            }
        } else if (isSulfuras) {
            // do nothing
        } else {
            if (quality > 0) {
                quality--;
            }
            sellIn--;
            if (sellIn < 0) {
                if (quality > 0) {
                    quality--;
                }
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
