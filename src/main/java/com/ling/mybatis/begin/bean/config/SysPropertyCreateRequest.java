package com.ling.mybatis.begin.bean.config;

import com.ling.mybatis.begin.bean.common.CreateRequestBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "创建系统配置")
public class SysPropertyCreateRequest extends CreateRequestBase {
    @ApiModelProperty(value = "配置组")
    public String sysGroup;

    @ApiModelProperty(value = "配置项名")
    public String sysKey;

    @ApiModelProperty(value = "配置值")
    public String sysValue;

    @ApiModelProperty(value = "备注")
    public String remark;

    @ApiModelProperty(value = "是否有效。1，有效。0，无效。")
    public Integer enable;

    // =======================
    public SysProperty toSysProperty() {
        SysProperty sysProperty = new SysProperty();
        sysProperty.sysGroup = sysGroup;
        sysProperty.sysKey = sysKey;
        sysProperty.sysValue = sysValue;
        sysProperty.remark = remark;
        sysProperty.enable = enable;
        sysProperty.createBy = createBy;
        return sysProperty;
    }
}
