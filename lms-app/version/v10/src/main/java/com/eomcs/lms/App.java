package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    // LessonHandler의 메서드를 사용하기 전에
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야 한다.
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    String command;
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      switch (command) {
        // 다른 클래스로 분리한 메서드를 호출할 때는 클래스 이름을 지정해야 한다.
        case "/lesson/add": LessonHandler.addLesson();
          break;
        case "/lesson/list": LessonHandler.listLesson();
          break;
        case "/member/add": MemberHandler.addMember();
          break;
        case "/member/list": MemberHandler.listMember();
          break;
        case "/board/add": BoardHandler.addBoard();
          break;
        case "/board/list": BoardHandler.listBoard();
          break;
        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("잘못된 명령입니다.");
          }
      }
    } while(!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");
    keyboard.close();

  }
}
