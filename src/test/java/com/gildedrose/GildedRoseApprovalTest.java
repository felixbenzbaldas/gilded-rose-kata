package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.util.List;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void legacyTest_thirtyDays() {
        List<Item> items = List.of(
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        );

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            stringBuilder.append("-------- day " + i + " --------");
            stringBuilder.append("\n");
            stringBuilder.append("name, sellIn, quality");
            stringBuilder.append("\n");
            for (Item item : items) {
                stringBuilder.append(item);
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
            Item.nextDay(items);
        }

        Approvals.verify(stringBuilder.toString());
    }
}
