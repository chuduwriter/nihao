package org.lanqiao.rbac.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.entity.Menus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MenuServiceTest extends BaseUnitTester{
  @Autowired
  private MenuService menuService;

  @Test
  public void findByPid() throws Exception {
    List<Menu> menus = menuService.findByPid(1);
    assertThat(menus).hasSize(3);
  }

  @Test
  public void findMenuByPid() throws Exception {
    List<Menus> menus = menuService.findMenuByPid();
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("code", 0);
    jsonMap.put("msg", "");
    jsonMap.put("data", menus);

    assertThat(menus).hasSize(4);
  }

  @Test
  public void findMenuByUserId() throws Exception {
    List<Menu> menus = menuService.findMenuByUserId(2);


    assertThat(menus).hasSize(1);
  }

}