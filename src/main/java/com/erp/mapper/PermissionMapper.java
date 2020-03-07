package com.erp.mapper;

import com.erp.util.TreeResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查所有权限--封装成Tree对象
     * @return
     */
    List<TreeResultUtil> list();

    /**
     *
     * @param roleId
     * @return
     */
    List<Integer> findPermissionIdsByRoleId(@Param("roleId") int roleId);

    /**
     *
     * @param roleId
     */
    void deleteRolePermByRoleId(@Param("roleId") Integer roleId);

    /**
     *
     * @param roleId
     * @param permIds
     */
    void addRolePerm(@Param("roleId") Integer roleId, @Param("permIds") int[] permIds);

    /**
     * 根据username查找到权限
     * @param username
     * @return
     */
    List<TreeResultUtil> getPerms(@Param("username") String username);
}
