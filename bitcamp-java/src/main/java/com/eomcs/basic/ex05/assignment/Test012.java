package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제1 : 입력 받은 두 정수 사이의 합계를 구하라.
//예)
//입력? 2 5
//2에서 5까지의 합은 14입니다.



public class Test012 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("입력? ");
    int no1 = keyScan.nextInt();
    int no2 = keyScan.nextInt();
    
    int sum = 0;
    while (no1 <= no2) {
      sum += no1;
      no1++;
    }
    
    // 2 + 3 + 4 + 5 + 6 + 7 = 27
    System.out.printf("%d에서 %d까지의 합은 %d입니다.\n", no1, no2, sum);
    keyScan.close();
    // 결과 피드백
    // 초기 입력 값이 변경되는 문제 있음.
  }
  
}
