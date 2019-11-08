package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.BrowsingHistory;
import org.apache.ibatis.jdbc.SQL;

public class BrowsingHistorySqlProvider {

    public String insertSelective(BrowsingHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("browsing_history");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUseId() != null) {
            sql.VALUES("use_id", "#{useId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getBrowseTime() != null) {
            sql.VALUES("browse_time", "#{browseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            sql.VALUES("video_id", "#{videoId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BrowsingHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("browsing_history");
        
        if (record.getUseId() != null) {
            sql.SET("use_id = #{useId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getBrowseTime() != null) {
            sql.SET("browse_time = #{browseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            sql.SET("video_id = #{videoId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}