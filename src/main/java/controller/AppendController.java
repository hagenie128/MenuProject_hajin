package controller;

import service.MenuService;
import vo.MenuVO;

import java.util.Scanner;

public class AppendController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("메뉴 정보를 추가합니다.....");
        System.out.print("등록할 메뉴번호 : ");
        String menuNo = sc.nextLine();

        try {
            //중복체크
            MenuService.getInstance().checkDuplicateMenuId(menuNo);

            System.out.println("등록할 메뉴명 : ");
            String name = sc.nextLine();
            System.out.println("메뉴 가격 : ");
            int price = sc.nextInt();
            sc.nextLine();
            System.out.println("메뉴 카테고리 : ");
            String category = sc.nextLine();
            System.out.println("판매 여부 : ");
            boolean isAvailable = sc.nextBoolean();

            boolean flag = MenuService.getInstance().appendMenu(
                    new MenuVO(menuNo, name, price, category, isAvailable));

            System.out.println(flag ? "메뉴정보 등록 성공" : "메뉴정보 등록 실패");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
