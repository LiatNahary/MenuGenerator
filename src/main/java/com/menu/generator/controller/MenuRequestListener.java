package com.menu.generator.controller;

import com.menu.generator.model.WeeklyMenu;
import com.menu.generator.service.MenuGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuRequestListener {

    @Autowired
    private MenuGenerator menuGenerator;

    @GetMapping(value = "weekly", produces = "application/json")
    public WeeklyMenu getWeeklyMenu(){
        return menuGenerator.composeWeeklyMenu();
    }

}
