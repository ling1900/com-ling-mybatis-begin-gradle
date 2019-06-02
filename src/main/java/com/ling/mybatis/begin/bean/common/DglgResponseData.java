package com.ling.mybatis.begin.bean.common;

import com.ling.mybatis.begin.dglgutil.ResCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回值（单条数据）")
public class DglgResponseData<D> extends DglgResponseBase {
    @ApiModelProperty(value = "返回数据")
    public D data;
    @ApiModelProperty(value = "条目数")
    public long total;
    // ==================
    public static <X,Y extends X> DglgResponseData<X> cmd(int cmd, Y data, long total) {
        DglgResponseData<X> response = new DglgResponseData<>();
        response.resCode = cmd;
        response.data = data;
        response.total = total;
        return response;
    }
    public static <X,Y extends X> DglgResponseData<X> cmd(int cmd, Y data) {
        if (data == null) {
            return cmd(cmd, data, 0);
        } else {
            return cmd(cmd, data, 1);
        }
    }
    public static <X,Y extends X> DglgResponseData<X> cmd(int cmd) {
        return cmd(cmd, null, 0);
    }
    public static <X> DglgResponseData fail(int resCode) {
        return cmd(resCode, null,0);
    }
    public static <X, Y extends X> DglgResponseData<X> success(Y data, long total) {
        return DglgResponseData.cmd(ResCode.Success, data, total);
    }
    public static <X, Y extends X> DglgResponseData<X> success(Y data) {
        return DglgResponseData.cmd(ResCode.Success, data);
    }
    public static <X, Y extends X> DglgResponseData<X> success() {
        return DglgResponseData.success(null);
    }
    // ===================
    public static <X> DglgResponseData<X> dupx(DglgResponseBase dglgResponseBase) {
        DglgResponseData<X> result = new DglgResponseData<>();
        result.init(dglgResponseBase);
        return result;
    }
}
