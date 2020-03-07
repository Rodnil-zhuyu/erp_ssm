package com.erp.controller;

import com.erp.pojo.Role;
import com.erp.service.RoleService;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("updatePerm")
    public boolean updatePerm(Integer roleId,int [] permIds){
        roleService.updatePerm(roleId,permIds);
        return true;
    }

    @RequestMapping("findPermissionIdsByRoleId")
    public List<Integer> findPermissionIdsByRoleId(int roleId){
        return roleService.findPermissionIdsByRoleId(roleId);
    }

    @RequestMapping("permissionList")
    public List<TreeResultUtil> permissionList(){
        return roleService.permissionList();
    }

    @RequestMapping("remove")
    public boolean remove(int [] ids){
        roleService.remove(ids);
        return true;
    }

    @RequestMapping("update")
    public boolean update(Role role){
        roleService.update(role);
        return true;
    }
    @RequestMapping("add")
    public boolean add(Role role){
        roleService.add(role);
        return true;
    }
    @RequestMapping("page")
    public EasyUiResultUtil<Role> page(Role role,
                                       @RequestParam(defaultValue = "1")int pageNum,
                                       @RequestParam(defaultValue = "2")int pageSize){
        return roleService.page(role,pageNum,pageSize);
    }


    @RequestMapping("findAll")
    public List<Role> findAll(){
        return roleService.findAll();
    }
}
