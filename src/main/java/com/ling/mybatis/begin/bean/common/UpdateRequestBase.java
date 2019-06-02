package com.ling.mybatis.begin.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ling.mybatis.begin.dglgutil.DglgConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description = "请求参数基类：更新实体")
public class UpdateRequestBase extends DglgRequestBase {
    @ApiModelProperty(value = "最后一次修改时间", example = DglgConst.ExampleValue_DateTime, hidden = true)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Date lastUpdateTime;
    @ApiModelProperty(value = "最后修改人", hidden = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String lastUpdateBy;
}
