package com.ohgiraffers.menu.view;

import com.ohgiraffers.menu.run.MenuController;

import java.util.Scanner;

public class MenuView {

    //private MenuController menuController = new MenuController();
    public void displayView(){



        /*
        ============ 멤버 관리 ====================
        1. 메뉴 전체 조회
        2. (음식)메뉴코드로 조회
        3. (음식)카테고리코드로 음식조회
        4. 신규 (음식)메뉴 추가
        5. (음식)기존메뉴 수정
        6. (삭제)메뉴삭제 삭제
        ==========================================
        멤버의 조회 결과의 결럼
       */
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("==============================");
            System.out.println("1. 전체메뉴 조회");
            System.out.println("2. 메뉴코드로 메뉴조회");
            System.out.println("3. 카테고리코드로 메뉴조회");
            System.out.println("4. 신규메뉴 추가");
            System.out.println("5. 메뉴 수정");
            System.out.println("6. 메뉴 삭제");

            int no = sc.nextInt();

            switch (no){
                case 1: menuController.showAllMenu(); break;
                case 2: menuController.selectMenuByCode(inputMenuCode()); break;
            }
        }while (true);
    }

    private Object inputMenuCode() {

    }
}
