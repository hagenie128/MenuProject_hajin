package vo;

import java.util.Objects;

public class MenuVO {
    private String menuNo;
    private String name;
    private int price;
    private String category;
    private boolean isAvailable;

    public MenuVO(String menuNo, String name, int price, String category, boolean isAvailable) {
        this.menuNo = menuNo;
        this.name = name;
        this.price = price;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isisAvailable() {
        return isAvailable;
    }

    public void setisAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return menuNo + ","+ name +","+ price + "," + category + "," + isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuVO menuVO = (MenuVO) o;
        return Objects.equals(menuNo, menuVO.menuNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuNo);
    }
}
