package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionKnowledge;
import org.apache.ibatis.jdbc.SQL;

public class QuestionKnowledgeSqlProvider {

    public String insertSelective(QuestionKnowledge record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_knowledge");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.VALUES("question_id", "#{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledgeId() != null) {
            sql.VALUES("knowledge_id", "#{knowledgeId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QuestionKnowledge record) {
        SQL sql = new SQL();
        sql.UPDATE("question_knowledge");
        
        if (record.getQuestionId() != null) {
            sql.SET("question_id = #{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledgeId() != null) {
            sql.SET("knowledge_id = #{knowledgeId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}