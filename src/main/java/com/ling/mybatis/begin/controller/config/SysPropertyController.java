package com.ling.mybatis.begin.controller.config;

import com.ling.mybatis.begin.bean.common.DglgResponse;
import com.ling.mybatis.begin.bean.common.DglgResponseList;
import com.ling.mybatis.begin.bean.config.SysProperty;
import com.ling.mybatis.begin.bean.config.SysPropertyCreateRequest;
import com.ling.mybatis.begin.bean.config.SysPropertyQuery;
import com.ling.mybatis.begin.bean.config.SysPropertyUpdateRequest;
import com.ling.mybatis.begin.dglgutil.CmdCode;
import com.ling.mybatis.begin.service.config.SysPropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统配置接口")
@RestController
public class SysPropertyController {
    @Autowired
    private SysPropertyService sysPropertyService;

    // ===================
    @ApiOperation(value = "查询系统配置")
    @PostMapping(CmdCode.SysPropertyQuery + ".do")
//    @NeedPms(Pms.SysPropertyQuery)
    public DglgResponseList<SysProperty> query(@RequestBody SysPropertyQuery query) {
        return sysPropertyService.query(query);
    }

    @ApiOperation(value = "创建系统配置")
    @PostMapping(CmdCode.SysPropertyCreate + ".do")
//    @NeedPms(Pms.SysPropertyCreate)
    public DglgResponse create(@RequestBody SysPropertyCreateRequest request) {
        return sysPropertyService.create(request);
    }

    @ApiOperation(value = "修改系统配置")
    @PostMapping(CmdCode.SysPropertyUpdate + ".do")
//    @NeedPms(Pms.SysPropertyUpdate)
    public DglgResponse update(@RequestBody SysPropertyUpdateRequest request) {
        return sysPropertyService.update(request);
    }

    @ApiOperation(value = "删除系统配置")
    @PostMapping(CmdCode.SysPropertyDelete + ".do")
//    @NeedPms({Pms.SysPropertyDelete})
    public DglgResponse delete(@RequestBody SysPropertyQuery query) {
        return sysPropertyService.delete(query);
    }

}
