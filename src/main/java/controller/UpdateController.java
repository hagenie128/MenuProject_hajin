package controller;

import exception.MenuException;
import service.MenuService;
import vo.MenuVO;

import java.util.Scanner;

public class UpdateController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("메뉴 정보를 수정합니다.....");
        System.out.print("수정할 메뉴번호 : ");
        String menuNo = sc.nextLine();

        try {
            //수정할 메뉴정보를 가져옴
            MenuVO vo = MenuService.getInstance().searchMenuId(menuNo);

            System.out.println("수정할 메뉴명 : ");
            vo.setName(sc.nextLine());
            System.out.println("수정할 가격 : ");
            vo.setPrice(sc.nextInt());
            sc.nextLine();
            System.out.println("수정할 카테고리 : ");
            vo.setCategory(sc.nextLine());
            System.out.println("판매여부 수정 : ");
            vo.setisAvailable(sc.nextBoolean());
            System.out.println("메뉴정보 수정 성공");
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            System.out.println("메뉴정보 수정에 실패했습니다.");
        }
    }
}
