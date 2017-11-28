package org.lanqiao.rbac.DTO;

import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.entity.Role;

public class TreeMenu {

    private Integer id;
    private Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public Integer getId() {
        return id;
    }
}
