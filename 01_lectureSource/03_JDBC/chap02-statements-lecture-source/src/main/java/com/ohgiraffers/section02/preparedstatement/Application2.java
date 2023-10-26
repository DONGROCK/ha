package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String empId = "202";

        try {
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?");// ? 위치홀더 // 쿼리문이 미완성인 상태
            pstmt.setString(1, empId); // 쿼리를 실행하는데 필요한 데이터 값을 추가 한 것.
                                                    // setString()과 같은 메소드의 첫번째 인자의 값은 1부터 위치를 잡는다.

            rset = pstmt.executeQuery();
            if (rset.next()){
                System.out.println(rset.getString("EMP_ID") +" : "+ rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
