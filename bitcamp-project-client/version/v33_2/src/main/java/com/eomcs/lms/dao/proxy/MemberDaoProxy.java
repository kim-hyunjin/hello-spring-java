package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;


// 프록시 객체는 작업 객체와 동일한 인터페이스를 구현해야 한다.

public class MemberDaoProxy implements MemberDao{
  String host;
  int port;

  public MemberDaoProxy(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public int insert(Member member) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/member/add");
      out.writeObject(member);
      out.flush();

      String response = in.readUTF();
      if(response.equals("FAIL")) {
        return 0;
      }
      return 1;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Member> findAll() throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/member/list");
      out.flush();
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        return null;
      }
      return (List<Member>) in.readObject();
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/member/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        return null;
      }
      return (Member) in.readObject();
    }
  }

  @Override
  public int update(Member member) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/member/update");
      out.writeObject(member);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        return 0;
      }
      return 1;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/member/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        return 0;
      }
      return 1;
    }
  }

}
