package hr.java.production.utils;

import hr.java.production.model.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImportItems {

    public static List<Item> importItems(List<Category> categories) {
        final String ITEMS_FILE = "dat/items.txt";
        List<Item> items = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(ITEMS_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            while (reader.ready()) {
                Long id = Long.valueOf(reader.readLine());
                Integer typeOfItem = Integer.valueOf(reader.readLine());
                Integer categoryChoice = Integer.valueOf(reader.readLine());
                Category category = categories.get(categoryChoice - 1);
                String name = reader.readLine();
                BigDecimal width = new BigDecimal(reader.readLine());
                BigDecimal height = new BigDecimal(reader.readLine());
                BigDecimal length = new BigDecimal(reader.readLine());
                BigDecimal productionCost = new BigDecimal(reader.readLine());
                BigDecimal sellingPrice = new BigDecimal(reader.readLine());
                BigDecimal tempDiscount = new BigDecimal(reader.readLine());
                Discount discount = new Discount(tempDiscount.divide(BigDecimal.valueOf(100)));
                if (discount.discountAmount().compareTo(BigDecimal.ZERO) > 0) {
                    sellingPrice = sellingPrice.multiply(discount.discountAmount());
                }

                switch (typeOfItem) {
                    case 1 :
                        Integer subType = Integer.valueOf(reader.readLine());
                        BigDecimal weight = BigDecimal.valueOf(Long.parseLong(reader.readLine()));
                        switch (subType) {
                            case 1 :
                                items.add(new Poultry(id, name, category, width, height, length, productionCost, sellingPrice, weight, discount));
                                break;
                            case 2 :
                                items.add(new Beef(id, name, category, width, height, length, productionCost, sellingPrice, weight, discount));
                                break;
                        }
                        break;
                    case 2:
                        Integer warranty = Integer.valueOf(reader.readLine());
                        items.add(new Laptop(id, name, category, width, height, length, productionCost, sellingPrice, discount, warranty));
                        break;
                    case 3:
                        items.add(new Item(id, name, category, width, height, length, productionCost, sellingPrice, discount));
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Ne postoji datoteka " + ITEMS_FILE);
            ex.printStackTrace();
        } catch (IOException e) {
            System.err.println("Greška");
        }
        return items;
    }
}
