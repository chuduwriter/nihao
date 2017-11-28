package org.lanqiao.rbac.api;

import org.lanqiao.rbac.DTO.TreeMenu;
import org.web2017.web.rest.Result;
import org.web2017.web.rest.ResultGenerator;
import org.lanqiao.rbac.entity.Menu;
import org.lanqiao.rbac.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by web2017 on 2017/08/23.
*/
@RestController
@RequestMapping("/rbac/menu")
public class MenuAPI {
    @Resource
    private MenuService menuService;

    @PostMapping
    public Result add(Menu menu) {
        menuService.save(menu);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        menuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(Menu menu) {
        menuService.update(menu);
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping
    public Result list(Integer page, Integer limit) {
        PageInfo pageInfo = menuService.findAll(page,limit);
        return ResultGenerator.genSuccessLayUIResult(pageInfo.getList(),pageInfo.getTotal());
    }
    @GetMapping("/p/{pid}") // /rbac/menu/1
    public Result list(@PathVariable("pid") Integer pid){
        return ResultGenerator.genSuccessResult(menuService.findByPid(pid));
    }
    @RequestMapping("/menu")
    public Result getAllMenu(){
        return ResultGenerator.genSuccessResult(menuService.findMenuAll());
    }

    @GetMapping("/menuPid")
    public  Result getMenuPid(){
        Map<String, Object> resultMap = new HashMap<>();
        int countId=menuService.count();
        System.out.print(countId);
        return ResultGenerator.genSuccessResult(menuService.findMenuByPid());
    }
    @GetMapping("/menuUserId/{id}")
     public Result MenuUserId(@PathVariable("id") Integer id){
        return  ResultGenerator.genSuccessResult(menuService.findMenuByUserId(id));
     }

}