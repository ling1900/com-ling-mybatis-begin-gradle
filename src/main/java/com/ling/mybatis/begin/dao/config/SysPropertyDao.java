package com.ling.mybatis.begin.dao.config;

import com.ling.mybatis.begin.bean.config.SysProperty;
import com.ling.mybatis.begin.bean.config.SysPropertyQuery;
import com.ling.mybatis.begin.bean.config.SysPropertyUpdateRequest;
import com.ling.mybatis.begin.dao.DaoBase;
import org.springframework.stereotype.Repository;

@Repository
public class SysPropertyDao extends DaoBase<SysProperty, SysPropertyQuery, SysPropertyUpdateRequest> {
    @Override
    protected String namespace() {
        return "sysProperty";
    }
}
