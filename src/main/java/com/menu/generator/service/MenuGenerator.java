package com.menu.generator.service;


import com.menu.generator.model.WeeklyMenu;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MenuGenerator {

    public static final int NUM_OF_DAYS_IN_WEEK = 5;
    String pathToCategories = "C:/Users/User/Documents/javaProject/category";

    private String[] getElementsInPath(String path) {
        File file = new File(path);
        return file.list();
    }

    private String randomElement(String[] allCategories) {
        int randIdx = ThreadLocalRandom.current().nextInt(allCategories.length);
        return allCategories[randIdx];
    }

    private boolean doseContainCategory(String[] categoryList, String Category) {
        return Arrays.asList(categoryList).contains(Category);
    }

    private String[] weeklyCategoryListGenerator() {
        String[] allCategories = getElementsInPath(pathToCategories);
        String[] categoryList = new String[NUM_OF_DAYS_IN_WEEK];
        int i = 0;
        while (i < categoryList.length) {

            String category = randomElement(allCategories);
            if (!doseContainCategory(categoryList, category)) {
                categoryList[i] = category;
                i++;
            }
        }

        return categoryList;
    }



    private String getPathToRecipes(String category) {
        String pathToRecipe = (pathToCategories + "/" + (category));
        return pathToRecipe;
    }


    private String[] weeklyMenuGenerator() {
        String[] categoryList = weeklyCategoryListGenerator();
        String[] menu = new String[NUM_OF_DAYS_IN_WEEK];

        for (int categoryIndex = 0; categoryIndex < NUM_OF_DAYS_IN_WEEK; categoryIndex++) {
            String category = categoryList[categoryIndex];
            String pathToRecipes = getPathToRecipes(category);
            String[] catgoryRecipes = getElementsInPath(pathToRecipes);
            menu[categoryIndex] = randomElement (catgoryRecipes);
        }
        return menu;
    }

    public WeeklyMenu composeWeeklyMenu(){
        WeeklyMenu weeklyMenu = new WeeklyMenu(weeklyMenuGenerator());
        return weeklyMenu;
    }
}
