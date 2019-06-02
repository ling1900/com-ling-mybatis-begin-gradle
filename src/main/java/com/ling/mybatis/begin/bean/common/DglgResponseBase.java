package com.ling.mybatis.begin.bean.common;

import com.ling.mybatis.begin.dglgutil.ResCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回值基类。")
public abstract class DglgResponseBase {
    // ===================
    // ===================
    @ApiModelProperty(value = "返回码，命令编号（websocket）")
    public int resCode = ResCode.Success;

    // ====================
    // ====================
    public boolean isFail() {
        return resCode < 0;
    }
    public boolean isSucc() {
        return resCode > 0;
    }
    // ====================
    protected void init(DglgResponseBase other) {
        this.resCode = other.resCode;
    }
}
