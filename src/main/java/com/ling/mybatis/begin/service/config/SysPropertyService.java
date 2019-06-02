package com.ling.mybatis.begin.service.config;

import com.ling.mybatis.begin.bean.common.DglgResponse;
import com.ling.mybatis.begin.bean.common.DglgResponseList;
import com.ling.mybatis.begin.bean.config.SysProperty;
import com.ling.mybatis.begin.bean.config.SysPropertyCreateRequest;
import com.ling.mybatis.begin.bean.config.SysPropertyQuery;
import com.ling.mybatis.begin.bean.config.SysPropertyUpdateRequest;

public interface SysPropertyService {
    DglgResponseList<SysProperty> query(SysPropertyQuery query);
    DglgResponse create(SysPropertyCreateRequest request);
    DglgResponse update(SysPropertyUpdateRequest request);
    DglgResponse delete(SysPropertyQuery query);
}
