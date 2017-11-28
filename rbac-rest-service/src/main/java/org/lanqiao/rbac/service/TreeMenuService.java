package org.lanqiao.rbac.service;

import org.lanqiao.rbac.DTO.TreeMenu;
import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.repository.TreeMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TreeMenuService {
    @Autowired
    private TreeMenuMapper treeMenuMapper;

    public List<Map<String,Object>> findFaterMenu(Integer roleId){
        List<Map<String,Object>> objectList=new ArrayList<Map<String,Object>>();
        List<TreeMenu > objectList1=treeMenuMapper.selectFaterMenu(roleId);
        for(TreeMenu  menu:objectList1){
            Map<String,Object> map=new LinkedHashMap<String, Object>();
           // map.put("id",menu.getMenu().getId());
            map.put("name",menu.getMenu().getTitle());
            map.put("children",selectSonMenu(menu.getMenu().getId(),roleId));
            objectList.add(map);
        }
        return objectList;

    }

    public List<Map<String,Object>> selectSonMenu(Integer menuId,Integer roleId){
        List<Map<String,Object>> menuList1=new ArrayList<Map<String,Object>>();
        List<TreeMenu > menuList=treeMenuMapper.selectSonMenu(roleId,menuId);
        for(TreeMenu  menu:menuList){
            Map<String,Object> map=new LinkedHashMap<String,Object>();
           // map.put("name",menu.getMenu().getId());
            map.put("name",menu.getMenu().getTitle());
            menuList1.add(map);
        }
        return  menuList1;
    }

}
