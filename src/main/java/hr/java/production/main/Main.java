package hr.java.production.main;

import hr.java.production.enums.Cities;
import hr.java.production.exception.ConflictingArticlesException;
import hr.java.production.exception.ConflictingCategoryException;
import hr.java.production.model.*;
import hr.java.production.sort.ProductionSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    final static int NUMBER_OF_CATEGORIES = 3;
    final static int NUMBER_OF_ITEMS = 5;
    final static int NUMBER_OF_FACTORIES = 2;
    final static int NUMBER_OF_STORES = 2;
    final static String CATEGORIES_FILE = "dat/categories.txt";
    final static String ITEMS_FILE = "dat/items.txt";
    final static String FACTORIES_FILE = "dat/factories.txt";
    final static String STORES_FILE = "dat/stores.txt";
    /**
     * sluzi za unos kategorija
     *
     * @return vraca unesene kategorije
     */


    /**
     * sluzi za provjeru duplikata unesene kategorije
     *
     * @param name ime
     * @param categories kategorije
     */
    static void checkDuplicateCategory(String name, ArrayList<Category> categories) {
        for (Category cat : categories) {
            if (cat.getName().compareTo(name) == 0) {
                throw new ConflictingCategoryException("Kategorija vec postoji, unesi drugu.");
            }
        }
    }

    /**
     * sluzi za unos artikala
     *
     * @param categories kategorije
     * @return vraca unesene artikle
     */



    /**
     * sluzi za unos tvornica
     *
     * @param items artikli
     * @return vraca unesene tvornice
     */


    /**
     * sluzi za unos trgovina
     *
     * @param items artikli
     * @return vraca unesene trgovine
     */


    /**
     * sluzi za provjeru duplikata unesenih artikala
     *
     * @param item artikli
     * @param selectedItems odabrani artikli
     * @throws ConflictingArticlesException iznimka
     */
    static void checkDuplicateItem(Item item, Set<Item> selectedItems) throws ConflictingArticlesException {
        if (selectedItems.contains(item)) throw new ConflictingArticlesException("Artikl vec postoji, unesi drugi.");
    }

    /*public static void main(String[] args) {

        logger.info("Program je pokrenut.");

        ArrayList<Category> categories = inputCategories();
        logger.info("Unesene su kategorije");
        List<Item> items = inputItems(categories);
        logger.info("Uneseni su artikli");
        ArrayList<Factory> factories = inputFactories(items);
        logger.info("Unesene su tvornice");
        ArrayList<Store> stores = inputStores(items);
        logger.info("Unesene su trgovine");

        Map<Category, List<Item>> itemsByCategory = getCategoryListMap(categories, items);
        printMaxVolumeFactory(factories);
        printMinCostStore(stores);
        printMaxKcalAndMaxPriceItems(items);
        printShortestWarrantyLaptop(items);
        printMaxAndMinCostItemsByCategory(itemsByCategory);

        items = sortItemsByPrice(items);

        printMaxCostEdibleAndTechnical(items);


        items = items.stream().sorted((i1, i2) -> i1.getHeight().multiply(i1.getLength()).multiply(i1.getHeight()).compareTo(i2.getHeight().multiply(i2.getLength()).multiply(i2.getHeight()))).collect(Collectors.toList());

        BigDecimal avgVolume = items.stream()
                .map(item -> item.getVolume())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(items.size()), 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal avgPrice = items.stream()
                .filter(item -> item.getVolume().compareTo(avgVolume) > 0)
                .map(item -> item.getSellingPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(items.size()), 2, BigDecimal.ROUND_HALF_UP);

        System.out.println("\nSrednja cijena svih artikala koji imaju nadprosječni volumen je " + avgPrice);

        double avgItems = stores.stream()
                .mapToInt(store -> store.getItems().size())
                .average().getAsDouble();


        List<Store> aboveAvgItemsStores = (stores.stream()
                .filter(store -> store.getItems().size() > avgItems)).toList();

        System.out.println("\nTrgovine koje imaju nadprosječan broj artikala su ");
        for (Store str : aboveAvgItemsStores) {
            System.out.println(str.getName());
        }

        List<Item> discountedItems = items.stream()
                .filter(item -> item.getDiscount().compareTo(BigDecimal.ZERO) > 0)
                .toList();
        if (!discountedItems.isEmpty()) {
            System.out.println("\nProizvodi pronadeni");
        } else {
            Optional result = Optional.empty();
            System.out.println("\nNe postoje proizvodi s popustom\n");
        }

        stores.stream()
                .map(store -> store.getItems()).forEach(System.out::println);

    }*/

    private static void printMaxCostEdibleAndTechnical(List<Item> items) {
        ArrayList<Item> edibleItems = new ArrayList<>();
        ArrayList<Item> technicalItems = new ArrayList<>();
        for (Item item : items) {
            boolean b = item instanceof Edible ? edibleItems.add(item) : technicalItems.add(item);
        }

        System.out.println("Najskuplji jestivi artikl je " + edibleItems.get(0).getName() + ", a najjeftiniji " + edibleItems.get(edibleItems.size() - 1).getName());
        System.out.println("Najskuplji tehnicki artikl je " + technicalItems.get(0).getName() + ", a najjeftiniji " + technicalItems.get(edibleItems.size() - 1).getName());
    }

    private static void printMaxAndMinCostItemsByCategory(Map<Category, List<Item>> itemsByCategory) {
        for (Category c : itemsByCategory.keySet()) {
            System.out.println("Najskuplji artikl iz kategorije " + c.toString() + " je " + itemsByCategory.get(c).get(0).getName());
            System.out.println("Najjeftiniji artikl iz kategorije " + c.toString() + " je " + itemsByCategory.get(c).get(itemsByCategory.get(c).size() - 1).getName());
        }

        System.out.println();
    }

    private static void printShortestWarrantyLaptop(List<Item> items) {
        Item shortestWarrantyLaptop = items.get(0);
        Integer shortestWarranty = Integer.MAX_VALUE;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Laptop && ((Laptop) items.get(i)).getWarranty() < shortestWarranty) {
                shortestWarranty = ((Laptop) items.get(i)).getWarranty();
                shortestWarrantyLaptop = items.get(i);
            }
        }

        System.out.println("\nLaptop koji ima najkraci garantni rok je " + shortestWarrantyLaptop.getName());
        System.out.println();
    }

    private static void printMaxKcalAndMaxPriceItems(List<Item> items) {
        Integer maxKcal = 0;
        Item maxKcalEdible = items.get(0);
        BigDecimal maxPrice = new BigDecimal(0);
        Item maxPriceEdible = items.get(0);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Edible) {
                if (((Edible) items.get(i)).calculateKCal() > maxKcal) {
                    maxKcal = ((Edible) items.get(i)).calculateKCal();
                    maxKcalEdible = items.get(i);
                }
                if (((Edible) items.get(i)).calculateSellingPrice().compareTo(maxPrice) > 0) {
                    maxPrice = ((Edible) items.get(i)).calculateSellingPrice();
                    maxPriceEdible = items.get(i);
                }
            }
        }
        System.out.println("\nNamirnica koja ima najveci broj kcal je " + maxKcalEdible.getName());
        System.out.println("Namirnica koja ima najvecu ukupnu cijenu s obzirom na tezinu je " + maxPriceEdible.getName());
    }

    private static void printMinCostStore(ArrayList<Store> stores) {
        Store minCostStore = stores.get(0);
        BigDecimal minCost = BigDecimal.valueOf(Integer.MAX_VALUE);
        for (int i = 0; i < stores.size(); i++) {
            ArrayList<Item> itemsByStore = new ArrayList<Item>(stores.get(i).getItems());
            for (int j = 0; j < itemsByStore.size(); j++) {
                BigDecimal itemCost = itemsByStore.get(j).getSellingPrice();
                if (itemCost.compareTo(minCost) < 0) {
                    minCost = itemCost;
                    minCostStore = stores.get(i);
                }
            }
        }
        System.out.println("Trgovina koja prodaje najjeftiniji proizvod je " + minCostStore.getName());
    }

    private static void printMaxVolumeFactory(ArrayList<Factory> factories) {
        Factory maxVolumeFactory = factories.get(0);
        BigDecimal maxVol = new BigDecimal(0);
        for (int i = 0; i < factories.size(); i++) {
            ArrayList<Item> itemsByFactory = new ArrayList<Item>(factories.get(i).getItems());
            for (int j = 0; j < itemsByFactory.size(); j++) {
                BigDecimal itemVol = itemsByFactory.get(j).getWidth().multiply(itemsByFactory.get(j).getHeight()).multiply(itemsByFactory.get(j).getLength());
                if (itemVol.compareTo(maxVol) > 0) {
                    maxVol = itemVol;
                    maxVolumeFactory = factories.get(i);
                }
            }
        }
        System.out.println("\nTvornica koja proizvodi artikl s najvecim volumenom je " + maxVolumeFactory.getName());
    }

    private static Map<Category, List<Item>> getCategoryListMap(ArrayList<Category> categories, List<Item> items) {
        Map<Category, List<Item>> itemsByCategory = new HashMap<Category, List<Item>>();
        for (Category c : categories) {
            ArrayList<Item> getItemsByCategory = new ArrayList<>();
            for (Item i : items) {
                if (i.getCategory().equals(c)) getItemsByCategory.add(i);
            }
            itemsByCategory.put(c, sortItemsByPrice(getItemsByCategory));
        }
        return itemsByCategory;
    }

    private static List<Item> sortItemsByPrice(List<Item> items) {
        Collections.sort(items, new ProductionSorter(true));
        return items;
    }
}
