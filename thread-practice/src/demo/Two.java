package demo;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        long countNum;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("숫자를 입력하세요.");
            countNum = scanner.nextLong();
            Thread t1 = new Thread(new RunnableCounter(0, countNum/2));
            Thread t2 = new Thread(new RunnableCounter(countNum/2+1, countNum));
            long before = System.currentTimeMillis();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            long after = System.currentTimeMillis();
            System.out.printf("총 소요시간: %d", after - before);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        } catch (InterruptedException e) {
            System.out.println("쓰레드 작업 수행 중 에러 발생...");
        }


    }
}
