package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

// "/hello" 명령어 처리
public class ComputePlusCommand implements Command {
  Prompt prompt;

  public ComputePlusCommand(Prompt input) {
    this.prompt = input;
  }

  @Override
  public void execute() {
    int a = prompt.inputInt("수1? ");
    int b = prompt.inputInt("수2? ");
    System.out.printf("계산결과는 %d 입니다.\n", a + b);
  }
}
