# 36_2 - DB 커넥션 객체 공유하기

## 학습목표

- 한 개의 DB 커넥션을 여러 DAO에서 공유할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/mariadb/BoardDaoImple.java 생성
- src/main/java/com/eomcs/lms/dao/mariadb/LessonDaoImple.java 생성
- src/main/java/com/eomcs/lms/dao/mariadb/MemberDaoImple.java 생성
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습  

### 훈련1: 한개의 DB 커넥션 객체를 DAO 모두가 공유하여 사용하라.
- com.eomcs.lms.ClientApp 변경
- com.eomcs.lms.dao.mariadb.XxxDaoImpl 변경