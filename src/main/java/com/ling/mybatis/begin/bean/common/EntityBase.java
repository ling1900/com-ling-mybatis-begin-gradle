package com.ling.mybatis.begin.bean.common;

import com.ling.mybatis.begin.dglgutil.DglgConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description = "实体类基类")
public abstract class EntityBase {
//    // ========================
    @ApiModelProperty(value = "创建时间", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date createTime;
    @ApiModelProperty(value = "创建人")
    public String createBy;
    @ApiModelProperty(value = "最后一次修改时间", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date lastUpdateTime;
    @ApiModelProperty(value = "最后修改人")
    public String lastUpdateBy;
}
