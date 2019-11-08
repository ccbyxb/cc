package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Course;
import org.apache.ibatis.jdbc.SQL;

public class CourseSqlProvider {

    public String insertSelective(Course record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearnCount() != null) {
            sql.VALUES("learn_count", "#{learnCount,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            sql.VALUES("difficulty", "#{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            sql.VALUES("subject_id", "#{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectionId() != null) {
            sql.VALUES("direction_id", "#{directionId,jdbcType=INTEGER}");
        }
        
        if (record.getLearnTime() != null) {
            sql.VALUES("learn_time", "#{learnTime,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Course record) {
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearnCount() != null) {
            sql.SET("learn_count = #{learnCount,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            sql.SET("difficulty = #{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            sql.SET("subject_id = #{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectionId() != null) {
            sql.SET("direction_id = #{directionId,jdbcType=INTEGER}");
        }
        
        if (record.getLearnTime() != null) {
            sql.SET("learn_time = #{learnTime,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}