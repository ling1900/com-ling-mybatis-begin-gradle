package com.ling.mybatis.begin.serviceImpl;

import com.ling.mybatis.begin.bean.common.DglgResponse;
import com.ling.mybatis.begin.bean.common.DglgResponseData;
import com.ling.mybatis.begin.bean.common.DglgResponseList;
import com.ling.mybatis.begin.bean.common.EntityBase;
import com.ling.mybatis.begin.bean.common.QueryBase;
import com.ling.mybatis.begin.bean.common.UpdateRequestBase;
import com.ling.mybatis.begin.dao.DaoBase;
import com.ling.mybatis.begin.dglgutil.DglgConst;

import java.util.List;

public abstract class ServiceImplBase2<E extends EntityBase,Q extends QueryBase,U extends UpdateRequestBase,D extends DaoBase> //
{

    // =====================
    protected abstract DaoBase<E, Q, U> getDao();
    protected abstract int resCodeWhenCantFound();
    // =====================
    public DglgResponseList<E> query(Q query) {
        int qt = query.qt;
        if (qt == DglgConst.Qt_Both) {
            long count = getDao().count(query);
            List<E> list = getDao().query(query);
            return DglgResponseList.success(count, list);
        } else if (qt == DglgConst.Qt_List) {
            List<E> list = getDao().query(query);
            return DglgResponseList.success(0, list);
        }
        long count = getDao().count(query);
        return DglgResponseList.success(count, null);
    }

    public DglgResponseData<E> queryOne(Q query) {
        query.pageSize = 1;
        List<E> list = getDao().query(query);
        if (list.isEmpty()) {
            return DglgResponseData.fail(resCodeWhenCantFound());
        }
        return DglgResponseData.success(list.get(0));
    }

    public DglgResponseData<E> sumAll(Q query) {
        E data = getDao().sumAll(query);
        return DglgResponseData.success(data);
    }

    public DglgResponse delete(Q query) {
        int rows = getDao().delete(query);
        return DglgResponse.success(rows);
    }

    public DglgResponse insert(E entity) {
        int rows = getDao().insert(entity);
        return DglgResponse.success(rows);
    }

    public DglgResponse update(U entity) {
        int rows = getDao().update(entity);
        return DglgResponse.success(rows);
    }

}
