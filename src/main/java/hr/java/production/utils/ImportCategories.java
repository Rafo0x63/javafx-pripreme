package hr.java.production.utils;

import hr.java.production.model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportCategories {

    public static List<Category> importCategories(){
        List<Category> categories = new ArrayList<>();
        final String CATEGORIES_FILE = "dat/categories.txt";

        try {
            FileInputStream fis = new FileInputStream(CATEGORIES_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            while (reader.ready()) {
                Long id = Long.valueOf(reader.readLine());
                String name = reader.readLine();
                String desc = reader.readLine();
                categories.add(new Category(id, name, desc));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Ne postoji datoteka " + CATEGORIES_FILE);
            ex.printStackTrace();
        } catch (IOException e) {
            System.err.println("Greška");
        }
        return categories;
    }
}
