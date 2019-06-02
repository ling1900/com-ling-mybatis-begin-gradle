package com.ling.mybatis.begin.serviceImpl.config;

import com.ling.mybatis.begin.bean.common.DglgResponse;
import com.ling.mybatis.begin.bean.config.SysProperty;
import com.ling.mybatis.begin.bean.config.SysPropertyCreateRequest;
import com.ling.mybatis.begin.bean.config.SysPropertyQuery;
import com.ling.mybatis.begin.bean.config.SysPropertyUpdateRequest;
import com.ling.mybatis.begin.dao.DaoBase;
import com.ling.mybatis.begin.dao.config.SysPropertyDao;
import com.ling.mybatis.begin.dglgutil.ResCode;
import com.ling.mybatis.begin.service.config.SysPropertyService;
import com.ling.mybatis.begin.serviceImpl.ServiceImplBase2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPropertyServiceImpl //
        extends ServiceImplBase2<SysProperty, SysPropertyQuery, SysPropertyUpdateRequest, SysPropertyDao> //
    implements SysPropertyService {
    @Autowired
    private SysPropertyDao sysPropertyDao;

    @Override
    protected DaoBase getDao() {
        return sysPropertyDao;
    }

    @Override
    protected int resCodeWhenCantFound() {
        return ResCode.CantFoundSysProperty;
    }

    @Override
    public DglgResponse create(SysPropertyCreateRequest request) {
        return this.insert(request.toSysProperty());
    }
}
