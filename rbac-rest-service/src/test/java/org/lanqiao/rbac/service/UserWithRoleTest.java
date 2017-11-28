package org.lanqiao.rbac.service;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.lanqiao.rbac.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.lanqiao.rbac.DTO.UserWithRole;
import java.util.HashMap;
import java.util.List;

public class UserWithRoleTest extends  BaseUnitTester{
    @Autowired
    private  UserWithRoleService userWithRoleService;
    @Test
    public void testFindUserAndRole() {
        List<UserWithRole> list=userWithRoleService.findUserAndRole();
        for (UserWithRole userWithRole:list){
            System.out.println(userWithRole.getAccount().getAccount());
        }


    }

    @Test
    public void testFindUserAndRolePage() {
        PageInfo pageInfo=userWithRoleService.findAll(1,2);
        Assert.assertNotNull(pageInfo);


    }



}
