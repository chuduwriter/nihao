-- ----------------------------
-- Records of rbac_menu
-- ----------------------------
/*
INSERT INTO `rbac_menu` VALUES ('1', '系统管理', '0', 'menu.do?getMenuListnew', '1', '0', '系统管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('2', '日志管理', '0', 'menu.do?menu.do/getMenuListnew', '1', '0', '操作日志的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('3', '菜单管理', '1', 'userTable.html', '1', '0', '对菜单进行操作的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('4', '角色管理', '1', 'roleTable.html', '1', '0', '对角色进行管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('5', '用户管理', '1', 'user.do?method=ShowUserByRoleUrl', '1', '0', '从来管理用户的菜单', null, null);
*/

INSERT INTO `rbac_menu` VALUES ('1', '后台首页', '0', 'menu.do?getMenuListnew', '1', '0', '系统管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('2', '我的面板', '0', 'myPanel.html', '1', '0', '操作日志的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('3', '用户管理', '0', 'user.html', '1', '0', '对菜单进行操作的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('4', '内容管理', '0', 'contain.html', '1', '0', '对角色进行管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('5', '会员管理', '0', 'member.html', '1', '0', '从来管理用户的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('6', '系统管理', '0', 'system', '1', '0', '系统管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('7', '个人设置', '2', 'personManagerTable.html', '1', '0', '操作日志的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('8', '修改密码', '2', 'updatePasswordTable', '1', '0', '对菜单进行操作的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('9', '用户列表', '3', 'userWithroleTable.html', '1', '0', '对角色进行管理的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('10', '角色管理', '3', 'roleTable.html', '1', '0', '从来管理用户的菜单', null, null);
INSERT INTO `rbac_menu` VALUES ('11', '菜单管理', '3', 'menuTable.html', '1', '0', '系统管理的菜单', null, null);
