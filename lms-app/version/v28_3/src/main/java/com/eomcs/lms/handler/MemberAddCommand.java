package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddCommand implements Command {
  List<Member> memberList;
  public Prompt prompt;

  public MemberAddCommand(Prompt input, List<Member> list) {
    this.prompt = input;
    this.memberList = list;
  }

  @Override
  public void execute() {
    Member member = new Member();
    member.setNo(prompt.inputInt("번호? "));
    member.setName(prompt.inputString("이름? "));
    member.setEmail(prompt.inputString("이메일? "));
    member.setPassword(prompt.inputString("암호? "));
    member.setPhoto(prompt.inputString("사진? "));
    member.setTel(prompt.inputString("전화번호? "));
    member.setDate(new Date(System.currentTimeMillis()));
    this.memberList.add(member);
    System.out.println("저장되었습니다.");
  }
}

