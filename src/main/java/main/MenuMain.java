package main;

import controller.Controller;
import controller.HandlerMapping;
import service.MenuService;

import java.util.Scanner;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("-- 메뉴 관리 프로그램 --");
                System.out.println("1. 메뉴 정보 추가");
                System.out.println("2. 메뉴 정보 삭제");
                System.out.println("3. 메뉴 정보 수정");
                System.out.println("4. 메뉴 검색 (이름)");
                System.out.println("5. 전체 메뉴 조회");
                System.out.println("0. 프로그램 종료");
                System.out.println("원하시는 메뉴번호를 입력하세요 :");
                int no = sc.nextInt();
                sc.nextLine();

                Controller controller =
                        HandlerMapping.getInstance().createController(no);

                if (controller != null)
                    controller.execute(sc);

                if (no == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
        }finally {
            MenuService.getInstance().exportToCSV();
        }
    }
}
