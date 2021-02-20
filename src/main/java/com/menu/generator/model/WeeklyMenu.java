package com.menu.generator.model;

import java.util.List;
import java.util.Objects;

public class WeeklyMenu {
    private String[] weeklyRecipes;

    public WeeklyMenu(String[] weeklyRecipes) {
        this.weeklyRecipes = weeklyRecipes;
    }

    public String[] getWeeklyRecipes() {
        return weeklyRecipes;
    }

    public void setWeeklyRecipes(String[] weeklyRecipes) {
        this.weeklyRecipes = weeklyRecipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeeklyMenu that = (WeeklyMenu) o;
        return Objects.equals(weeklyRecipes, that.weeklyRecipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weeklyRecipes);
    }

    @Override
    public String toString() {
        return "WeeklyMenu{" +
                "weeklyRecipes=" + weeklyRecipes +
                '}';
    }
}
