package org.lanqiao.rbac.service;

import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleTest extends BaseUnitTester {
    @Autowired
    private UserRoleService userRoleService;
    @Test
    public void TestDeleteUserIdWithRoleId(){
        userRoleService.deleteUserAndRole(1,1);
    }
}
