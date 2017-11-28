package org.lanqiao.rbac.RedisTest;


import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.lanqiao.rbac.base.BaseUnitTester;
import org.lanqiao.rbac.entity.Account;
import org.lanqiao.rbac.entity.UserProfile;
import org.lanqiao.rbac.service.AccountService;
import org.lanqiao.rbac.service.UserProfileService;
import org.lanqiao.rbac.service.UserWithRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;


public class TestRedis extends BaseUnitTester {
    @Autowired
    private AccountService accountService ;
    @Autowired
    private UserWithRoleService userWithRoleService;


    @Test
    public void addTest(){
      Set<String> stringSet=accountService.findPermissionsById("1");
      assertThat(stringSet).isNotNull();
      System.out.println("======-=================");
        stringSet=accountService.findPermissionsById("1");
        assertThat(stringSet).isNotNull();

    }
    @Test
    public void addTest1(){
        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-redis.xml");
        final RedisTemplate<String, Object> redisTemplate = appCtx.getBean("redisTemplate",RedisTemplate.class);
        //添加一个 key
        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        value.set("lp", "hello word");
        //获取 这个 key 的值
        System.out.println(value.get("lp"));
        //添加 一个 hash集合
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "lp");
        map.put("age", "26");
        hash.putAll("lpMap", map);
        //获取 map
        System.out.println(hash.entries("lpMap"));
        //添加 一个 list 列表
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush("lpList", "lp");
        list.rightPush("lpList", "26");
        //输出 list
        System.out.println(list.range("lpList", 0, 1));
        //添加 一个 set 集合
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add("lpSet", "lp");
        set.add("lpSet", "26");
        set.add("lpSet", "178cm");
        //输出 set 集合
        System.out.println(set.members("lpSet"));
        //添加有序的 set 集合
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add("lpZset", "lp", 0);
        zset.add("lpZset", "26", 1);
        zset.add("lpZset", "178cm", 2);
        //输出有序 set 集合
        System.out.println(zset.rangeByScore("lpZset", 0, 2));
    }

    @Test
    public void addTest2(){
        PageInfo pageInfo=userWithRoleService.findAll(1,3);
//        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-redis.xml");
//        final RedisTemplate<String, Object> redisTemplate = appCtx.getBean("redisTemplate",RedisTemplate.class);
//        ValueOperations<String, Object> value = redisTemplate.opsForValue();
//        value.set("pageInfo", pageInfo);
//        System.out.println(value.get("pageInfo"));
        assertThat(pageInfo).isNotNull();
        System.out.println("======-=================");
        pageInfo=userWithRoleService.findAll(1,3);
//        if(value.get("pageInfo")==null){
//            pageInfo=userWithRoleService.findAll(1,3);
//        }
//        else{
//            pageInfo=(PageInfo)value.get("pageInfo");
//        }
        assertThat(pageInfo).isNotNull();

    }
    }

