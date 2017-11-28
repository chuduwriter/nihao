package org.lanqiao.rbac.repository;

import org.lanqiao.rbac.DTO.UserWithRole;
import org.lanqiao.rbac.base.Mapper;
import org.lanqiao.rbac.entity.UserRole;

import java.util.HashMap;
import java.util.List;


public interface UserWithRoleMapper {
    List<UserWithRole> selectUserAndRole();
    List<HashMap<String,UserWithRole>> selectUserAndRoleMap();
}
