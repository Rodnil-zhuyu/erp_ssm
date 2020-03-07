package com.erp.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    /**
     *
     * @param ids
     */
    void remove(@Param("ids") int[] ids);

    /**
     *
     * @param id
     * @param roleIds
     */
    void add(@Param("empId") Integer empId, @Param("roleIds") int[] roleIds);

}
