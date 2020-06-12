package com.adouge.service.user.service;

import com.adouge.core.mybatis.base.BaseService;
import com.adouge.service.user.entity.User;
import com.adouge.service.user.entity.UserInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author : Vinson
 * @date : 2020/5/15 5:19 下午
 */
public interface IUserService extends BaseService<User> {
    UserInfo userInfo(String tenantId, String account, String password);
}
