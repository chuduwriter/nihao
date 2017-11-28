package org.lanqiao.rbac.RedisTest;

import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRedisTest extends BaseUnitTester{
    @Autowired
    private MenuService menuService;

    @Test
    public void TestFindMenuByUserId(){
        List<Menu> menuList =menuService.findMenuByUserId(1);
        assertThat(menuList).isNotNull();
        System.out.println("----------------------");
        menuList=menuService.findMenuByUserId(1);
        assertThat(menuList).isNotNull();
    }
    @Test
    public void TestFindMenuByPid(){
        List<Menu> menuList=menuService.findByPid(1);
        assertThat(menuList).isNotNull();
        System.out.println("----------------------");
        menuList=menuService.findByPid(1);
        assertThat(menuList).isNotNull();
    }

}
