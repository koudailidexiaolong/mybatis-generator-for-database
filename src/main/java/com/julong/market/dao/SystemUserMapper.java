package com.julong.market.dao;

import com.julong.market.dao.entity.SystemUserInfo;

public interface SystemUserMapper {
    public abstract int deleteByPrimaryKey(String userId);

    public abstract int insert(SystemUserInfo record);

    public abstract int insertSelective(SystemUserInfo record);

    public abstract SystemUserInfo selectByPrimaryKey(String userId);

    public abstract SystemUserInfo selectBySelectiveParameters(SystemUserInfo record);

    public abstract int selectCountBySelective(SystemUserInfo record);

    public abstract int updateByPrimaryKeySelective(SystemUserInfo record);

    public abstract int updateByPrimaryKey(SystemUserInfo record);
}