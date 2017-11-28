package org.lanqiao.rbac.repository;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.rbac.base.Mapper;
import org.lanqiao.rbac.entity.UserProfile;

import java.util.HashMap;
import java.util.List;

public interface UserProfileMapper extends Mapper<UserProfile> {

  /*  @Select(" select a.account,up.nick_name,up.real_name,up.gender,r.name from rbac_account a left join rbac_user_profile up on a.user_profile_id=up.id left join rbac_user_role ur on a.id=ur.user_id left join rbac_role r on r.id=ur.role_id where a.id=#{id}")
   */

}