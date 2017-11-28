package org.lanqiao.rbac.repository;

import org.lanqiao.rbac.base.Mapper;
import org.lanqiao.rbac.entity.RoleMenu;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {
    public int insertRoleAndMenuBatch(List<RoleMenu> roleMenuList);
}