package com.ling.mybatis.begin.dglgutil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "响应码。编号六位，前三位为组编号，后三位为组内编号。错误的响应码，必须为负数。")
public class ResCode {
    @ApiModelProperty(value = "成功")
    public static final int Success = 1;
    public static final int CantFoundSysProperty = -110001;
}
