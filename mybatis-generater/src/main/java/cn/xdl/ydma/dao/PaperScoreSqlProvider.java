package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.PaperScore;
import org.apache.ibatis.jdbc.SQL;

public class PaperScoreSqlProvider {

    public String insertSelective(PaperScore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_score");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTotalScore() != null) {
            sql.VALUES("total_score", "#{totalScore,jdbcType=INTEGER}");
        }
        
        if (record.getMyScore() != null) {
            sql.VALUES("my_score", "#{myScore,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaperId() != null) {
            sql.VALUES("paper_id", "#{paperId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PaperScore record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_score");
        
        if (record.getTotalScore() != null) {
            sql.SET("total_score = #{totalScore,jdbcType=INTEGER}");
        }
        
        if (record.getMyScore() != null) {
            sql.SET("my_score = #{myScore,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaperId() != null) {
            sql.SET("paper_id = #{paperId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}