package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItemJavaApprovalTest {

    @Test
    public void javvApprovalOneDay() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        List<Item> items = List.of(
            new Item("+5 Dexterity Vest", 10, 20),
            agedBrie,
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        );

        Item.nextDay(items);

        Approvals.verifyAll("Item", items);
    }
}
