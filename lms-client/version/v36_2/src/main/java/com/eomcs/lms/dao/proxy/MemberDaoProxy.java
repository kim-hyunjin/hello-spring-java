package com.eomcs.lms.dao.proxy;

import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;


// 프록시 객체는 작업 객체와 동일한 인터페이스를 구현해야 한다.

public class MemberDaoProxy implements MemberDao{
  DaoProxyHelper daoProxyHelper;

  public MemberDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @Override
  public int insert(Member member) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {out.writeUTF("/member/add");
    out.writeObject(member);
    out.flush();

    String response = in.readUTF();
    if(response.equals("FAIL")) {
      return 0;
    }
    return 1;});
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Member> findAll() throws Exception {
    return (List<Member>) daoProxyHelper.request((in, out) -> {out.writeUTF("/member/list");
    out.flush();
    String response = in.readUTF();
    if (response.equals("FAIL")) {
      return null;
    }
    return (List<Member>) in.readObject();
    });
  }

  @Override
  public Member findByNo(int no) throws Exception {
    return (Member)daoProxyHelper.request((in, out) -> {out.writeUTF("/member/detail");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();

    if (response.equals("FAIL")) {
      return null;
    }
    return (Member) in.readObject();
    });
  }

  @Override
  public int update(Member member) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {out.writeUTF("/member/update");
    out.writeObject(member);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      return 0;
    }
    return 1;
    });
  }

  @Override
  public int delete(int no) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {out.writeUTF("/member/delete");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();

    if (response.equals("FAIL")) {
      return 0;
    }
    return 1;});
  }

}//MemberDaoProxy{}
