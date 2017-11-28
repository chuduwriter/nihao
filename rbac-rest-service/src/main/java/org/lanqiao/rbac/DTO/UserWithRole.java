package org.lanqiao.rbac.DTO;

import org.lanqiao.rbac.entity.Account;
import org.lanqiao.rbac.entity.Role;
import org.lanqiao.rbac.entity.UserProfile;

public class UserWithRole {


    private  Integer id;
    private Account account;
    private UserProfile userProfile;
    private Role role;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Account getAccount() {
        return account;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserWithRole{" +
                "id=" + id +
                ", account=" + account.getAccount() +
                ", userProfile=" + userProfile.getNickName() +
                ", role=" + role.getName() +
                '}';
    }
}
