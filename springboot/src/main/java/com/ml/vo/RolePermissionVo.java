package com.ml.vo;

import com.ml.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionVo {
    /**
     * 菜单数据
     */
    private List<Permission> permissionList = new ArrayList<Permission>();
    /**
     * 该角色原有分配的菜单数据
     */
    private Object [] checkList;
}

