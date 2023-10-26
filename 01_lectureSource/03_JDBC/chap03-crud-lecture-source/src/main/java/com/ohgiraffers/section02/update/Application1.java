package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
            String query = prop.getProperty("updateMenu");
        System.out.println("query = " + query);

            Scanner sc = new Scanner(System.in);
            System.out.print("변경할 메뉴 번호를 입력하세요 :");
            int menuCode = sc.nextInt();
            sc.nextLine(); // 인트다음엔 공백하나
            System.out.print("변경할 메뉴 이름을 입력하세요 : ");
            String menuName = sc.nextLine();

            System.out.print("변경할 메뉴 가격를 입력하세요 : ");
            int menuPrice = sc.nextInt();

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);
            pstmt.setInt(2, menuPrice);
            pstmt.setInt(3, menuCode);

            result = pstmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0){
            System.out.println("메뉴수정성공");
        }else {
            System.out.println("메뉴수정실패..");
        }
    }
}
