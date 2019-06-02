package com.ling.mybatis.begin.bean.common;

import com.ling.mybatis.begin.dglgutil.ResCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "返回值（列表数据）")
public class DglgResponseList<D> extends DglgResponseBase {
    // ====================
    @ApiModelProperty(value = "总条目数")
    public long total;
    @ApiModelProperty(value = "返回数据")
    public List<D> list;
    // ====================
    public static <X,Y extends X> DglgResponseList<X> cmd(int cmd, long count, List<Y> list) {
        DglgResponseList<X> response = new DglgResponseList<>();
        response.resCode = cmd;
        response.total = count;
        response.list = (List<X>)list;
        return response;
    }

    public static <X> DglgResponseList<X> fail(int resCode) {
        return cmd(resCode, 0, null);
    }

    public static <X, Y extends X> DglgResponseList<X> success(long count, List<Y> list) {
        return DglgResponseList.cmd(ResCode.Success, count, list);
    }
    public static <X, Y extends X> DglgResponseList<X> success(List<Y> list) {
        return DglgResponseList.cmd(ResCode.Success, 0, list);
    }
    public static <X, Y extends X> DglgResponseList<X> success(long count) {
        return DglgResponseList.cmd(ResCode.Success, count, null);
    }
    // ====================
    public static <X> DglgResponseList dupx(DglgResponseBase dglgResponseBase) {
        DglgResponseList<X> result = new DglgResponseList<>();
        result.init(dglgResponseBase);
        return result;
    }
}
