package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Answer;
import org.apache.ibatis.jdbc.SQL;

public class AnswerSqlProvider {

    public String insertSelective(Answer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("answer");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueId() != null) {
            sql.VALUES("issue_id", "#{issueId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Answer record) {
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueId() != null) {
            sql.SET("issue_id = #{issueId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}