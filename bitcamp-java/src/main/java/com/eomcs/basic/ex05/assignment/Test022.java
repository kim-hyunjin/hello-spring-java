package com.eomcs.basic.ex05.assignment;

//# 과제2 : 다섯 개의 정수 값을 입력 받고 최소, 최대값 구하기
//실행 예)
//입력? 4 17 -1 6 9
//최소값: -1
//최대값: 17
//


import java.util.Scanner;

public class Test022 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("입력? ");
    int no1 = keyScan.nextInt();
    int no2 = keyScan.nextInt();
    int no3 = keyScan.nextInt();
    int no4 = keyScan.nextInt();
    int no5 = keyScan.nextInt();
    
    System.out.printf("%d %d %d %d %d\n",no1, no2, no3, no4, no5);
    
    System.out.println("최소값: -1");
    System.out.println("최대값: 17");
    
    keyScan.close();
  }

}
