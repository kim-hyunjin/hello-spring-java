package com.eomcs.basic.ex05;

// 산술 연산자 : 암시적 형변환과 연산우선순위
public class Exam01_6 {
    public static void main(String[] args) {
      float r1 = 5 / 2 + 3.1f;
      // 계산 순서:
      // r1 = int(5) / int(2) + float(3.1);
      // r1 = int(2) + float(3.1);
      // r1 = float(2.0) + float(3.1)
      // r1 = float(5.1)
      // => 연산우선순위에 따라 계산할 때마다 암시적 형변환이 이루어진다.
      // => 모든 값을 최종 결과 타입으로 바꿔서 계산하는 것이 아니다.
      System.out.println(r1);
      
      float r2 = 3.1f + 5 / 2;
      // 계산 순서:
      // r2 = float(3.1) + int(5) / int(2)
      // r2 = float(3.1) + int(2)
      // r2 = float(3.1) + float(2.0)
      // r2 = float(5.1)
      System.out.println(r2);
      
    }
}
