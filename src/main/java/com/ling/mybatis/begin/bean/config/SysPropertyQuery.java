package com.ling.mybatis.begin.bean.config;

import com.ling.mybatis.begin.bean.common.QueryBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "查询系统配置")
public class SysPropertyQuery extends QueryBase {
    @ApiModelProperty
    public List<Long> seqIds;
    @ApiModelProperty(value = "配置组")
    public List<String> sysGroups;
    @ApiModelProperty(value = "配置项名")
    public List<String> sysKeys;

    // =======================
    @Override
    protected String toColumnName(String fieldName) {
        switch (fieldName) {
            case "seqId":
                return "seq_id";
            case "sysGroup":
                return "sys_group";
            case "sysKey":
                return "sys_key";
            case "sysValue":
                return "sys_value";
            case "remark":
                return "remark";
            case "enable":
                return "enable";
            default:
                return super.toColumnName(fieldName);
        }
    }
}
