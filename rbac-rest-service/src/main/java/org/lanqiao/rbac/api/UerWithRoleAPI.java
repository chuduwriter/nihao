package org.lanqiao.rbac.api;

import com.github.pagehelper.PageInfo;
import org.lanqiao.rbac.DTO.UserWithRole;
import org.lanqiao.rbac.service.UserWithRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web2017.web.rest.Result;
import org.web2017.web.rest.ResultGenerator;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@RestController
@RequestMapping("/rbac/userwith/role")
public class UerWithRoleAPI {
    @Resource
    private UserWithRoleService userWithRoleService;

    @GetMapping
    public Result list(Integer page, Integer limit) {
        PageInfo pageInfo = userWithRoleService.findAll(page,limit);
        return ResultGenerator.genSuccessLayUIResult(pageInfo.getList(),pageInfo.getTotal());
    }

}
