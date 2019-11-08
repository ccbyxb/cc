package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionType;
import org.apache.ibatis.jdbc.SQL;

public class QuestionTypeSqlProvider {

    public String insertSelective(QuestionType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_type");
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=INTEGER}");
        }
        
        if (record.getTypeName() != null) {
            sql.VALUES("type_name", "#{typeName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QuestionType record) {
        SQL sql = new SQL();
        sql.UPDATE("question_type");
        
        if (record.getTypeName() != null) {
            sql.SET("type_name = #{typeName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("type_id = #{typeId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}