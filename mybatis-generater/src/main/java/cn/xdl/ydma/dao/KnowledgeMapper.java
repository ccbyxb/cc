package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Knowledge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface KnowledgeMapper {
    @Delete({
        "delete from knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into knowledge (Id, name, ",
        "subject_id, chapter_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{subjectId,jdbcType=INTEGER}, #{chapterId,jdbcType=INTEGER})"
    })
    int insert(Knowledge record);

    @InsertProvider(type=KnowledgeSqlProvider.class, method="insertSelective")
    int insertSelective(Knowledge record);

    @Select({
        "select",
        "Id, name, subject_id, chapter_id",
        "from knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="chapter_id", property="chapterId", jdbcType=JdbcType.INTEGER)
    })
    Knowledge selectByPrimaryKey(Integer id);

    @UpdateProvider(type=KnowledgeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Knowledge record);

    @Update({
        "update knowledge",
        "set name = #{name,jdbcType=VARCHAR},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "chapter_id = #{chapterId,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Knowledge record);
}