package com.eomcs.lms.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
@MultipartConfig(maxFileSize = 10000000)
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/add")
  public String add(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    if(request.getMethod().equals("GET")) {
      return "/member/form.jsp";
    }
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));

    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      String dirPath = request.getServletContext().getRealPath("/upload/member");
      String filename = UUID.randomUUID().toString();
      photoPart.write(dirPath + "/" + filename);
      member.setPhoto(filename);
    }

    if (memberService.add(member) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("회원을 추가할 수 없습니다.");
    }
  }

  @RequestMapping("/member/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (memberService.delete(no) > 0) { // 삭제했다면,
      return "redirect:list";
    } else {
      throw new Exception("삭제할 회원 번호가 유효하지 않습니다.");
    }
  }

  @RequestMapping("/member/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);
    request.setAttribute("member", member);
    return "/member/detail.jsp";
  }

  @RequestMapping("/member/list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    request.setAttribute("list", memberService.list());
    return "/member/list.jsp";
  }

  @RequestMapping("/member/search")
  public String search(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.search(keyword);
    request.setAttribute("list", members);
    return "/member/search.jsp";
  }

  @RequestMapping("/member/update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      String dirPath = request.getServletContext().getRealPath("/upload/member");
      String filename = UUID.randomUUID().toString();
      photoPart.write(dirPath + "/" + filename);
      member.setPhoto(filename);
    }
    if (memberService.update(member) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("변경할 회원 번호가 유효하지 않습니다.");
    }
  }
}
