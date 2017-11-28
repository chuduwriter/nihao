package org.lanqiao.rbac.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.entity.Menus;
import org.lanqiao.rbac.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.util.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleMenuTest extends BaseUnitTester {
    @Autowired
    private RoleMenuService roleMenuService;
    @Test
    public void TestaddRoleAndMenuBatch(){
        RoleMenu roleMenu=new RoleMenu();
        roleMenu.setRoleId(2);
        roleMenu.setMenuId(9);
        roleMenu.setRoleId(2);
        roleMenu.setMenuId(4);
        roleMenu.setRoleId(2);
        roleMenu.setMenuId(7);
        List<RoleMenu> roleMenus=new ArrayList<>();
        roleMenus.add(roleMenu);
        int a=roleMenuService.addRoleAndMenuBatch(roleMenus);
        System.out.print(a);

    }
}
