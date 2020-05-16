package com.adouge.core.mybatis.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author : Vinson
 * @date : 2020/5/15 1:19 下午
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public boolean save(T entity) {
//        TODO 保存用户
        entity.setUpdatedTime(LocalDateTime.now());
        entity.setCreatedTime(LocalDateTime.now());
        return super.save(entity);
    }

    @Override
    public boolean updateById(T entity) {
//        TODO 保存用户
        entity.setUpdatedTime(LocalDateTime.now());
        return super.updateById(entity);
    }

    @Override
    public boolean deleteLogic(@NotEmpty List<Long> ids) {
        return super.removeByIds(ids);
    }

}