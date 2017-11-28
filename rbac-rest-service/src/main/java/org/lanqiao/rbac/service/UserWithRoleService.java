package org.lanqiao.rbac.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.lanqiao.rbac.DTO.UserWithRole;

import org.lanqiao.rbac.repository.UserWithRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
@CacheConfig(cacheManager = "redisCacheManager")
public class UserWithRoleService {
    @Autowired
    private UserWithRoleMapper userWithRoleMapper;


    @Cacheable
    public List<UserWithRole> findUserAndRole(){

        return userWithRoleMapper.selectUserAndRole();
    }
    @Cacheable
    public List<HashMap<String ,Object>> findUserAndRoleMap(){
        List<UserWithRole> list=userWithRoleMapper.selectUserAndRole();
        HashMap<String ,Object>  hashMap=new HashMap<>();
        List<HashMap<String ,Object>> hashMapList=new ArrayList<>();
        for(UserWithRole userWithRole:list){
            hashMap.put("id",userWithRole.getId());
            hashMap.put("account",userWithRole.getAccount().getAccount());
            hashMap.put("nickName",userWithRole.getUserProfile().getNickName());
            hashMap.put("realName",userWithRole.getUserProfile().getRealName());
            hashMap.put("gender",userWithRole.getUserProfile().getGender());
            hashMap.put("roleId",userWithRole.getRole().getId());
            hashMap.put("name",userWithRole.getRole().getName());
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }
    @Cacheable(value = "common", key = "'users_'+#pageNumber")
    public PageInfo findAll(Integer pageNumber, Integer pageSize) {
        return PageHelper.startPage(pageNumber, pageSize).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userWithRoleMapper.selectUserAndRoleMap();
            }
        });
    }
}
