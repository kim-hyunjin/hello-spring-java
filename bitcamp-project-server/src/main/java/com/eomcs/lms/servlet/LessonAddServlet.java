package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/add")
public class LessonAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>강의 입력</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>강의 입력</h1>");
      out.println("<form action='add' method='post'>");
      out.println("강의명: <input name='title' type='text'><br>");
      out.println("내용:<br>");
      out.println("<textarea name='description' rows='5' cols='60'></textarea><br>");
      out.println("강의 시작일: <input name='startDate' type='date'><br>");
      out.println("강의 종료일: <input name='endDate' type='date'><br>");
      out.println("총 강의시간: <input name='totalHours' type='number'><br>");
      out.println("일 강의시간: <input name='dayHours' type='number'><br>");
      out.println("<button>제출</button>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      req.setCharacterEncoding("utf-8");
      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter out = resp.getWriter();

      ServletContext servletContext = getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      LessonService lessonService = iocContainer.getBean(LessonService.class);

      Lesson lesson = new Lesson();
      lesson.setTitle(req.getParameter("title"));
      lesson.setDescription(req.getParameter("description"));
      lesson.setStartDate(Date.valueOf(req.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(req.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(req.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(req.getParameter("dayHours")));

      lessonService.add(lesson);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>강의 입력</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>강의 입력 결과</h1>");
      out.println("<p>새 강의를 등록했습니다.</p>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
