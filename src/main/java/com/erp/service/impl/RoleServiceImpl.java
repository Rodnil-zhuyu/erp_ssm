package com.erp.service.impl;

import com.erp.mapper.PermissionMapper;
import com.erp.mapper.RoleMapper;
import com.erp.pojo.Role;
import com.erp.service.RoleService;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<TreeResultUtil> permissionList() {
        return permissionMapper.list();
    }

    @Override
    public void remove(int []ids) {
        roleMapper.remove(ids);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }

    @Override
    public EasyUiResultUtil<Role> page(Role role, int pageNum, int pageSize) {
        return new EasyUiResultUtil<Role>(roleMapper.count(role),
                roleMapper.page(role,(pageNum-1)*pageSize,pageSize));
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public List<Integer> findPermissionIdsByRoleId(int roleId) {
        return permissionMapper.findPermissionIdsByRoleId(roleId);
    }

    @Override
    public void updatePerm(Integer roleId, int[] permIds) {
        //先根据roleId进行删除权限
        permissionMapper.deleteRolePermByRoleId(roleId);
        //在跟进roleId和permIds进行增加
        permissionMapper.addRolePerm(roleId,permIds);
    }
}
