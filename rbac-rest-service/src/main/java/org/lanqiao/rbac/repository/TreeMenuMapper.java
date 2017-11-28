package org.lanqiao.rbac.repository;

import org.lanqiao.rbac.DTO.TreeMenu;
import org.lanqiao.rbac.entity.Menu;

import java.util.List;
import java.util.Map;

public interface TreeMenuMapper {

   List<TreeMenu > selectFaterMenu(Integer roleId);

   List<TreeMenu > selectSonMenu(Integer roleId,Integer menuId);
}
