package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionOptions;
import org.apache.ibatis.jdbc.SQL;

public class QuestionOptionsSqlProvider {

    public String insertSelective(QuestionOptions record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_options");
        
        if (record.getOptionId() != null) {
            sql.VALUES("option_id", "#{optionId,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.VALUES("question_id", "#{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getOptionName() != null) {
            sql.VALUES("option_name", "#{optionName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QuestionOptions record) {
        SQL sql = new SQL();
        sql.UPDATE("question_options");
        
        if (record.getQuestionId() != null) {
            sql.SET("question_id = #{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getOptionName() != null) {
            sql.SET("option_name = #{optionName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("option_id = #{optionId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}