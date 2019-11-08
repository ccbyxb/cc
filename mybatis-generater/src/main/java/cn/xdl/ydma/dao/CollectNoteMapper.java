package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.CollectNote;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CollectNoteMapper {
    @Delete({
        "delete from collect_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into collect_note (id, user_id, ",
        "note_id, collect_time)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{noteId,jdbcType=INTEGER}, #{collectTime,jdbcType=TIMESTAMP})"
    })
    int insert(CollectNote record);

    @InsertProvider(type=CollectNoteSqlProvider.class, method="insertSelective")
    int insertSelective(CollectNote record);

    @Select({
        "select",
        "id, user_id, note_id, collect_time",
        "from collect_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectNote selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CollectNoteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectNote record);

    @Update({
        "update collect_note",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "note_id = #{noteId,jdbcType=INTEGER},",
          "collect_time = #{collectTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectNote record);
}