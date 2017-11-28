package org.lanqiao.rbac.api;

import org.web2017.web.rest.Result;
import org.web2017.web.rest.ResultGenerator;
import org.lanqiao.rbac.entity.RoleMenu;
import org.lanqiao.rbac.service.RoleMenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* Created by web2017 on 2017/08/23.
*/
@RestController
@RequestMapping("/rbac/role/menu")
public class RoleMenuAPI {
    @Resource
    private RoleMenuService roleMenuService;

    @PostMapping
    public Result add(RoleMenu roleMenu) {
        roleMenuService.save(roleMenu);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        roleMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(RoleMenu roleMenu) {
        roleMenuService.update(roleMenu);
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        RoleMenu roleMenu = roleMenuService.findById(id);
        return ResultGenerator.genSuccessResult(roleMenu);
    }

    @GetMapping
    public Result list(Integer pageNumber, Integer pageSize) {
        PageInfo pageInfo = roleMenuService.findAll(pageNumber,pageSize);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/roleMenu",method = {RequestMethod.POST})
    @ResponseBody
    public Result addBath(@RequestBody RoleMenu [] roleMenu){
        List<RoleMenu> roleMenuList=new ArrayList<>();
       for(RoleMenu roleMenu1:roleMenu){
           roleMenuList.add(roleMenu1);
       }
        roleMenuService.addRoleAndMenuBatch(roleMenuList);
        return ResultGenerator.genSuccessResult();
    }

}
