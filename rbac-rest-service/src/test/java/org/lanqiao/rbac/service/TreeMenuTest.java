package org.lanqiao.rbac.service;

import org.junit.Assert;
import org.junit.Test;
import org.lanqiao.rbac.DTO.TreeMenu;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeMenuTest extends BaseUnitTester{
    @Autowired
    private  TreeMenuService treeMenuService;
    @Test
    public void TestFindFater(){
        List<Map<String,Object>> treeMenuList=treeMenuService.findFaterMenu(1);
        Assert.assertNotNull(treeMenuList);
    }
}
