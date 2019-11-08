package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Subject;
import org.apache.ibatis.jdbc.SQL;

public class SubjectSqlProvider {

    public String insertSelective(Subject record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("subject");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDirectionId() != null) {
            sql.VALUES("direction_id", "#{directionId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Subject record) {
        SQL sql = new SQL();
        sql.UPDATE("subject");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDirectionId() != null) {
            sql.SET("direction_id = #{directionId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}