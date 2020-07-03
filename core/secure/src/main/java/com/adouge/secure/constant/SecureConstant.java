package com.adouge.secure.constant;

/**
 * @author : Vinson
 * @date : 2020/6/15 1:05 下午
 */
public interface SecureConstant {
    /**
     * 认证请求头
     */
    String BASIC_HEADER_KEY = "Authorization";

    /**
     * 认证请求头前缀
     */
    String BASIC_HEADER_PREFIX = "Basic ";

    /**
     * 认证请求头前缀
     */
    String BASIC_HEADER_PREFIX_EXT = "Basic%20";

    /**
     * blade_client表字段
     */
    String CLIENT_FIELDS = "client_id, client_secret, access_token_time, refresh_token_time";

    /**
     * adouge_client查询语句
     */
    String BASE_STATEMENT = "select " + CLIENT_FIELDS + " from adouge_client";

    /**
     * adouge_client查询排序
     */
    String DEFAULT_FIND_STATEMENT = BASE_STATEMENT + " order by client_id";

    /**
     * 查询client_id
     */
    String DEFAULT_SELECT_STATEMENT = BASE_STATEMENT + " where client_id = ?";

}
