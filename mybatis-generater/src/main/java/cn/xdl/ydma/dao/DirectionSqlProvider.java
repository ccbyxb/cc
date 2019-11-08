package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Direction;
import org.apache.ibatis.jdbc.SQL;

public class DirectionSqlProvider {

    public String insertSelective(Direction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("direction");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Direction record) {
        SQL sql = new SQL();
        sql.UPDATE("direction");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}