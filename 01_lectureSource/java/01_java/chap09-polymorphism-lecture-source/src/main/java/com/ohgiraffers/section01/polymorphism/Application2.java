package com.ohgiraffers.section01.polymorphism;

public class Application2 {
    public static void main(String[] args) {

        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for (int i = 0; i < animals.length; i++) {
            animals[i].cry();
        }

        /*각 클래스별 고유한 메소드를 동작시키게 하기 위해서는
         * 다운캐스팅을 명시적으로 해주고 ClassCastExcption을 방지하기 위해서
         * instanceof 연산자를 이용
         * */
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Rabbit) { //animals[i] 가 토끼타입이면
                ((Rabbit)animals[i]).jump();
            } else if (animals[i] instanceof Tiger) { //animals[i] 가 호랑이타입이면
                ((Tiger)animals[i]).bite();
            } else {
                System.out.println("넌누구니?");
            }
        }
    }
}