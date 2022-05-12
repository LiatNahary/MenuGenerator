package com.menu.generator.service;

import com.menu.generator.model.WeeklyMenu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

@Service
public class MenuGenerator {

    public static final int NUM_OF_DAYS_IN_WEEK = 5;
    @Value("${my.fileLocation}")
    private String pathToCategories;


    private String[] getElementsInPath(String path) {
        File file = new File(path);
        return file.list();
    }

    private boolean doesContainCategory(String[] categoryList, String Category) {
        return Arrays.asList(categoryList).contains(Category);
    }

    private String[] weeklyCategoryListGenerator() {
        String[] allCategories = getElementsInPath(pathToCategories);
        String[] categoryList = new String[NUM_OF_DAYS_IN_WEEK];
        int i = 0;
        while (i < categoryList.length) {

            String category = RandomUtils.randomElement(allCategories);
            if (!doesContainCategory(categoryList, category)) {
                categoryList[i] = category;
                i++;
            }
        }

        return categoryList;
    }


    private String getPathToRecipes(String category) {
        return (pathToCategories + "/" + (category));
    }


    private String[] generateWeeklyMenu() {
        String[] categoryList = weeklyCategoryListGenerator();
        String[] menu = new String[NUM_OF_DAYS_IN_WEEK];

        for (int categoryIndex = 0; categoryIndex < NUM_OF_DAYS_IN_WEEK; categoryIndex++) {
            String category = categoryList[categoryIndex];
            String pathToRecipes = getPathToRecipes(category);
            String[] catgoryRecipes = getElementsInPath(pathToRecipes);
            menu[categoryIndex] = RandomUtils.randomElement(catgoryRecipes);
        }
        return menu;
    }

    public WeeklyMenu composeWeeklyMenu() {
        String[] generatedMenu = generateWeeklyMenu();
        return new WeeklyMenu(generatedMenu);
    }
}
