package org.lanqiao.rbac.repository;

import org.lanqiao.rbac.base.Mapper;
import org.lanqiao.rbac.entity.UserRole;

public interface UserRoleMapper extends Mapper<UserRole> {
   void deleteByUserAndRole(Integer userId,Integer roleId);

}