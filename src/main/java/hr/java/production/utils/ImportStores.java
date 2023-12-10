package hr.java.production.utils;

import hr.java.production.model.Item;
import hr.java.production.model.Store;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportStores {
    public static List<Store> inputStores(List<Item> items) {
        final String STORES_FILE = "dat/stores.txt";
        List<Store> stores = new ArrayList<Store>();

        try {
            FileInputStream fis = new FileInputStream(STORES_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            while (reader.ready()) {
                Long id = Long.valueOf(reader.readLine());
                String name = reader.readLine();
                String webAddress = reader.readLine();
                List<String> itemChoice = List.of(reader.readLine().split(","));
                List<Integer> itemChoiceList = new ArrayList<>();
                for (String num : itemChoice) {
                    itemChoiceList.add(Integer.parseInt(num));
                }
                Set<Item> selectedItems = new HashSet<>();
                for (int item : itemChoiceList) {
                    selectedItems.add(items.get(item - 1));
                }
                Integer typeOfStore = Integer.valueOf(reader.readLine());
                stores.add(new Store(id, name, webAddress, selectedItems));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Ne postoji datoteka " + STORES_FILE);
            ex.printStackTrace();
        } catch (IOException e) {
            System.err.println("Greška");
        }
        return stores;
    }
}
