package controller;

import exception.MenuException;
import service.MenuService;
import vo.MenuVO;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보 검색을 시작합니다.....");
        System.out.print("검색할 사원명 일부 : ");
        String name = sc.nextLine();

        try {
            ArrayList<MenuVO> list = MenuService.getInstance().searchForNameMenu(name);
            // 검색 결과 출력
            list.forEach(item -> System.out.println(item));

            MenuService.getInstance().searchForNameMenu(name).forEach(
                    item -> System.out.println(item));
        } catch (MenuException e) {
            throw new RuntimeException(e);
        }
    }
}
