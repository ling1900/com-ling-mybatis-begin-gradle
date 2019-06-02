package com.ling.mybatis.begin.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "请求基类：创建实体")
public class CreateRequestBase extends DglgRequestBase {

    @ApiModelProperty(value = "创建人", hidden = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String createBy;

}
