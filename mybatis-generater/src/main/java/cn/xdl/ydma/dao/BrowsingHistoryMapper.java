package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.BrowsingHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BrowsingHistoryMapper {
    @Delete({
        "delete from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into browsing_history (id, use_id, ",
        "course_id, browse_time, ",
        "video_id)",
        "values (#{id,jdbcType=INTEGER}, #{useId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{browseTime,jdbcType=TIMESTAMP}, ",
        "#{videoId,jdbcType=INTEGER})"
    })
    int insert(BrowsingHistory record);

    @InsertProvider(type=BrowsingHistorySqlProvider.class, method="insertSelective")
    int insertSelective(BrowsingHistory record);

    @Select({
        "select",
        "id, use_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="videoId", jdbcType=JdbcType.INTEGER)
    })
    BrowsingHistory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BrowsingHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BrowsingHistory record);

    @Update({
        "update browsing_history",
        "set use_id = #{useId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "browse_time = #{browseTime,jdbcType=TIMESTAMP},",
          "video_id = #{videoId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BrowsingHistory record);
}