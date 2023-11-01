package com.ohgiraffers.menu.run;

import java.util.List;

public class MenuController {
private final PrintResult printResult;
private final MenuService menuService;
    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }
    public void showAllMenu() {
        List<MenuDTO> menuList = menuService.showAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        } else{
            printResult.printErrorMessage("showAllMenu");
        }


    }
}
