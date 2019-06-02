package com.ling.mybatis.begin.dao;

import com.ling.mybatis.begin.bean.common.EntityBase;
import com.ling.mybatis.begin.bean.common.QueryBase;
import com.ling.mybatis.begin.bean.common.UpdateRequestBase;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class DaoBase<E extends EntityBase,Q extends QueryBase,U extends UpdateRequestBase> {
    @Autowired
    protected SqlSession sqlSession;

    // =====================
    protected abstract String namespace();
    // =====================
    public List<E> query(Q query) {
        return sqlSession.selectList(namespace()+".query", query);
    }

    public E queryOne(Q query) {
        query.pageSize = 1;
        List<E> result = this.query(query);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public E sumAll(Q query) {
        return sqlSession.selectOne(namespace()+".sumAll", query);
    }

    public long count(Q query) {
        return sqlSession.selectOne(namespace()+".count", query);
    }

    public int delete(Q query) {
        return sqlSession.delete(namespace()+".delete", query);
    }

    public int insert(E entity) {
        this.beforeInsert(entity);
        return sqlSession.insert(namespace()+".insert", entity);
    }

    public int update(U entity) {
        this.beforeUpdate(entity);
        return sqlSession.update(namespace()+".update", entity);
    }

    // =======================
    protected void beforeInsert(E entityBase) {
        if (entityBase.createTime == null) {
            entityBase.createTime = new Date();
        }
        if (entityBase.lastUpdateTime == null) {
            entityBase.lastUpdateTime = entityBase.createTime;
        }
        if (entityBase.lastUpdateBy == null) {
            entityBase.lastUpdateBy = entityBase.createBy;
        }
    }

    protected void beforeUpdate(UpdateRequestBase entityBase) {
        if (entityBase.lastUpdateTime == null) {
            entityBase.lastUpdateTime = new Date();
        }
    }

}
