package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Chapter;
import org.apache.ibatis.jdbc.SQL;

public class ChapterSqlProvider {

    public String insertSelective(Chapter record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("chapter");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Chapter record) {
        SQL sql = new SQL();
        sql.UPDATE("chapter");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}