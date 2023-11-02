package com.ohgiraffers.menu.run;


import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null){
            printResult.printSelectMenu(menu);
        } else {
            printResult.printErrorMessage("selectMenu");
        }
    }

    public void selectMenuByCategoryCode(Map<String, String> parameter) {
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = menuService.selectMenuByCategoryCode(categoryCode);
        if (menu != null){
            printResult.printSelectMenu(menu);
        } else {
            printResult.printErrorMessage("selectCategoryCode");
        }
    }

    public void newMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();

        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        System.out.println("menu" + menu);

        if (menuService.newMenu(menu)){
            printResult.printSuccessMessage("newMenu");

        } else {
            printResult.printErrorMessage("newMenu");
        }

    }
    public void changeMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

    }
}
