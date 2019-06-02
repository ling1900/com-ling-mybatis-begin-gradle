package com.ling.mybatis.begin.dglgutil;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "命令编号。编号六位，前三位为组编号，后三位为组内编号")
public class CmdCode {

//    public static final int QueryPermission = 100001;
//    public static final int InsertPermission = 100002;
//    public static final int UpdatePermission = 100003;
//    public static final int DeletePermission = 100004;

    public static final int RoleQuery = 101001;
    public static final int RoleInsert = 101002;
    public static final int RoleUpdate = 101003;
    public static final int RoleDelete = 101004;
    public static final int RoleQueryPmss = 101005;

//    public static final int UpdateRolePermission = 102001;
//    public static final int UpdateUserRole = 102002;

    public static final int UserQuery = 103001;
    public static final int UserInsert = 103002;
    public static final int UserUpdate = 103003;
    public static final int UserDelete = 103004;

    public static final int UserLogin = 103005;
    public static final int UserLogout = 103006;
    public static final int UserLoginInfo = 103007;


    public static final int SysPropertyQuery = 113001;
    public static final int SysPropertyCreate = 113002;
    public static final int SysPropertyUpdate = 113003;
    public static final int SysPropertyDelete = 113004;

}
