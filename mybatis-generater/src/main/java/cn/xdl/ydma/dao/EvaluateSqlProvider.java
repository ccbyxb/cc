package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Evaluate;
import org.apache.ibatis.jdbc.SQL;

public class EvaluateSqlProvider {

    public String insertSelective(Evaluate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("evaluate");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUseId() != null) {
            sql.VALUES("use_id", "#{useId,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            sql.VALUES("video_id", "#{videoId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.VALUES("like_count", "#{likeCount,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Evaluate record) {
        SQL sql = new SQL();
        sql.UPDATE("evaluate");
        
        if (record.getUseId() != null) {
            sql.SET("use_id = #{useId,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            sql.SET("video_id = #{videoId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.SET("like_count = #{likeCount,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}