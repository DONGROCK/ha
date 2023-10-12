package com.ohgiraffers.section05.calender;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Application2 {

    public static void main(String[] args) {

        /*
         * Calendar클래스를 이용한 인스턴스 생성 방법
         * 1, getInstance() static메소드를 이용해서 인스턴스를 반환받는 방법
         * 2. 후손클래스인 GregorianCalendar 클래스를 이용해서 인스턴스를 생성하는 방법
         * */

        Calendar calendar = Calendar.getInstance();
        System.out.println("calender = " + calendar);
        Calendar gregoriancalendar = new GregorianCalendar(); //다형성
        System.out.println(gregoriancalendar);

    }
}
