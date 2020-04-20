package com.eomcs.basic.ex05.assignment;

//# 과제2 : 다섯 개의 정수 값을 입력 받고 최소, 최대값 구하기
//실행 예)
//입력? 4 17 -1 6 9
//최소값: -1
//최대값: 17
//


import java.util.Scanner;

public class Test024 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    int[] no = new int[5];
    
    System.out.print("입력? ");
    for (int i = 0; i < 5; i++) {
      no[i] = keyScan.nextInt();
    }
    
    int min = no[0], max = no[0];
    
    for (int i = 1; i < 5; i++) {
      if (no[i] < min) {
        min = no[i];
      } else if (no[i] > max) {
        max = no[i];
      }
    }
    
    System.out.printf("최소값: %d\n", min);
    System.out.printf("최대값: %d", max);
    
    keyScan.close();
  }

}