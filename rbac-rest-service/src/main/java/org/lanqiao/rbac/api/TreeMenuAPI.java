package org.lanqiao.rbac.api;

import org.lanqiao.rbac.DTO.TreeMenu;
import org.lanqiao.rbac.service.TreeMenuService;
import org.springframework.web.bind.annotation.*;
import org.web2017.web.rest.Result;
import org.web2017.web.rest.ResultGenerator;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rbac/treeMenu")
public class TreeMenuAPI {
     @Resource
     private TreeMenuService treeMenuService;
    @PostMapping("/Treemenu/{roleId}")
    public Result TreeMenu(@PathVariable Integer roleId){
        List<Map<String,Object>> treeMenuList=treeMenuService.findFaterMenu(roleId);
        return ResultGenerator.genSuccessResult(treeMenuList);
    }
}
