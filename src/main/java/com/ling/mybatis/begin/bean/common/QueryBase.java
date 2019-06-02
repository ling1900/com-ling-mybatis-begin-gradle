package com.ling.mybatis.begin.bean.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ling.mybatis.begin.dglgutil.DglgConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel(description = "查询基类")
public abstract class QueryBase extends DglgRequestBase {
//    @ApiModelProperty
//    private List<String> productIds;
    // =================
    @ApiModelProperty(value = "创建时间，时间范围开始", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date createTimeBegin;
    @ApiModelProperty(value = "创建时间，时间范围结束", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date createTimeEnd;
    @ApiModelProperty(value = "创建人列表")
    public List<String> createBys;
    @ApiModelProperty(value = "更新时间，时间范围开始", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date lastUpdateTimeBegin;
    @ApiModelProperty(value = "更新时间，时间范围结束", example = DglgConst.ExampleValue_DateTime)
    @DateTimeFormat(pattern = DglgConst.DateFormat_Full)
    public Date lastUpdateTimeEnd;
    @ApiModelProperty(value = "最后更新人列表")
    public List<String> lastUpdateBys;
    // =================
//    @ApiModelProperty(value = "是否测试用户。0-非测试，1-测试")
//    private List<Integer> isTests;
    // =================
    @ApiModelProperty(value = DglgConst.Doc_Qt, example = "2")
    public int qt = DglgConst.Qt_Count;
    @ApiModelProperty(value = "起始行。从 0 开始。")
    public int rowNo = -1;
    @ApiModelProperty(value = "第几页。从 1 开始。", example = "1")
    public int pageNo = 1;
    @ApiModelProperty(value = "每页大小。默认 10", example = "20")
    public int pageSize = 10;
    @ApiModelProperty(value = "排序语句", notes = "使用列表，以保证顺序不会改变")
    public List<String> orderBys;
    // =================
    public int getRowNo() {
        if (rowNo >= 0) {
            return rowNo;
        }
        return (pageNo - 1) * pageSize;
    }

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    public String getOrderBy() {
        if (orderBys == null || orderBys.isEmpty() || orderBys.size()%2 != 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < orderBys.size() ;i+=2) {
            String key = orderBys.get(i);
            String value = orderBys.get(i+1);
            if (value == null || value.isEmpty()) {
                continue;
            }
            String columnName = toColumnName(key);
            if (columnName == null) {
                continue;
            }
            sb.append(columnName).append(' ').append(value).append(',');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    protected String toColumnName(String fieldName, String prefix) {
        switch (fieldName) {
            case "createTime":
                return prefix + "create_time";
            case "createBy":
                return prefix + "create_by";
            case "lastUpdateTime":
                return prefix + "last_update_time";
            case "lastUpdateBy":
                return prefix + "last_update_by";
            default:
//                return fieldName;
                // linglg：不指明的字段，不查询
                return null;
        }
    }

    protected String toColumnName(String fieldName) {
        return toColumnName(fieldName, "");
    }
}
