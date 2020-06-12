package com.adouge.service.system.service;

import com.adouge.core.mybatis.base.BaseService;
import com.adouge.service.system.entity.Role;
import com.adouge.service.system.vo.RoleVO;

import java.util.List;

/**
 * 角色表  服务类
 *
 * @author AdougeBabi
 * @since 2020-06-09
 */
public interface IRoleService extends BaseService<Role> {

    /**
     * 获取树列表
     * @return 树
     */
    List<RoleVO> tree();
}
