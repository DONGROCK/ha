package com.ohgiraffers.menu.run;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) { //전체조회
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "showAllMenu" : errorMessage = "전체메뉴 조회 실패.";
        }
        System.out.println(errorMessage);
    }
}
