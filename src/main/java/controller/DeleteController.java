package controller;

import exception.MenuException;
import service.MenuService;

import java.awt.*;
import java.util.Scanner;

public class DeleteController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("메뉴 정보를 삭제합니다.....");
        System.out.print("삭제할 메뉴번호 : ");
        String menuNo = sc.nextLine();

        try {
            MenuService.getInstance().deleteMenu(menuNo);
            System.out.println("메뉴정보 삭제 성공");
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }
    }
}
