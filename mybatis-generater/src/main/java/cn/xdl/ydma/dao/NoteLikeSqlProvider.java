package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.NoteLike;
import org.apache.ibatis.jdbc.SQL;

public class NoteLikeSqlProvider {

    public String insertSelective(NoteLike record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("note_like");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getNoteId() != null) {
            sql.VALUES("note_id", "#{noteId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeTime() != null) {
            sql.VALUES("like_time", "#{likeTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NoteLike record) {
        SQL sql = new SQL();
        sql.UPDATE("note_like");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getNoteId() != null) {
            sql.SET("note_id = #{noteId,jdbcType=INTEGER}");
        }
        
        if (record.getLikeTime() != null) {
            sql.SET("like_time = #{likeTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}