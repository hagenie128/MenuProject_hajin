package service;

import exception.MenuException;
import vo.MenuVO;

import java.io.*;
import java.util.ArrayList;

public class MenuService {
    private static MenuService instance = new MenuService();
    private ArrayList<MenuVO> list;

    private MenuService() {
        list = new ArrayList<>();
        loadToCSV();
    }

    private void loadToCSV() {
        try {
            FileReader fr = new FileReader("menu.csv");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while (true) {
                String str = br.readLine();
                if (str == null) break;
//                System.out.println(str);
                String[] arr = str.split(",");
                list.add(new MenuVO(arr[0], arr[1], Integer.parseInt(arr[2]),
                        arr[3], Boolean.parseBoolean(arr[4])));
            }
            System.out.println("메뉴 정보 로드 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static MenuService getInstance() {
        if (instance == null)
            instance = new MenuService();
        return instance;
    }

    public ArrayList<MenuVO> getList() {
        return list;
    }

    public void exportToCSV() {
        try {
            FileWriter fw = new FileWriter("menu.csv");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("menuNo,menuName, price, category, isAvailable");
            list.forEach(item -> pw.println(item));
            System.out.println("전체 메뉴 정보 저장 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void checkDuplicateEmployeeId(String id) {
        int idx = list.indexOf(new MenuVO(id, null, 0, null, false));
        if (idx != -1)
            throw new MenuException("이미 존재하는 메뉴번호입니다.");
    }

    public boolean appendEmployee(MenuVO menuVO) {
        return list.add(menuVO);
    }

    public void deleteMenu(String menuNo) {
        if(!list.remove(new MenuVO(menuNo, null, 0, null, false)))
            throw new MenuException("존재하지 않는 메뉴번호입니다.");
    }
}
