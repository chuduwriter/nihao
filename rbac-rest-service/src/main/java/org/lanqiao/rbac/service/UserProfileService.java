package org.lanqiao.rbac.service;

import org.lanqiao.rbac.repository.UserProfileMapper;
import org.lanqiao.rbac.entity.UserProfile;
import org.lanqiao.rbac.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


/**
 * Created by web2017 on 2017/08/23.
 */
@Service
@Transactional(readOnly=true)
public class UserProfileService extends AbstractService<UserProfile> {
    // 因为泛型注入，所以这里不必声明mapper的依赖

}
