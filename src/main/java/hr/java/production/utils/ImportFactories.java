package hr.java.production.utils;

import hr.java.production.enums.Cities;
import hr.java.production.model.Address;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportFactories {
    public static List<Factory> inputFactories(List<Item> items) {

        final String FACTORIES_FILE = "dat/factories.txt";
        List<Factory> factories = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(FACTORIES_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            while (reader.ready()) {
                Long id = Long.valueOf(reader.readLine());
                String name = reader.readLine();
                Address address = new Address.Builder(reader.readLine()).build();
                address.setHouseNumber(reader.readLine());
                Integer cityChoice = Integer.valueOf(reader.readLine());
                Cities city = null;
                switch (cityChoice) {
                    case 1 :
                        city = Cities.ZAGREB;
                        break;
                    case 2 :
                        city = Cities.ZABOK;
                        break;
                    case 3 :
                        city = Cities.KRAPINA;
                        break;
                    case 4 :
                        city = Cities.KARLOVAC;
                        break;
                }
                address.setCity(city);
                List<String> itemChoice = List.of(reader.readLine().split(","));
                List<Integer> itemChoiceList = new ArrayList<>();
                for (String num : itemChoice) {
                    itemChoiceList.add(Integer.parseInt(num));
                }
                Set<Item> selectedItems = new HashSet<>();
                for (int item : itemChoiceList) {
                    selectedItems.add(items.get(item - 1));
                }
                factories.add(new Factory(id, name, address, (selectedItems)));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Ne postoji datoteka " + FACTORIES_FILE);
            ex.printStackTrace();
        } catch (IOException e) {
            System.err.println("Greška");
        }
        return factories;
    }
}
