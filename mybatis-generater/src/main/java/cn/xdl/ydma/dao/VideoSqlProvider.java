package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Video;
import org.apache.ibatis.jdbc.SQL;

public class VideoSqlProvider {

    public String insertSelective(Video record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("video");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getChapterId() != null) {
            sql.VALUES("chapter_id", "#{chapterId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Video record) {
        SQL sql = new SQL();
        sql.UPDATE("video");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getChapterId() != null) {
            sql.SET("chapter_id = #{chapterId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}