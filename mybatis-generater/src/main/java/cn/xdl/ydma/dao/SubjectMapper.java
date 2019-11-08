package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SubjectMapper {
    @Delete({
        "delete from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into subject (id, name, ",
        "direction_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{directionId,jdbcType=INTEGER})"
    })
    int insert(Subject record);

    @InsertProvider(type=SubjectSqlProvider.class, method="insertSelective")
    int insertSelective(Subject record);

    @Select({
        "select",
        "id, name, direction_id",
        "from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER)
    })
    Subject selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Subject record);

    @Update({
        "update subject",
        "set name = #{name,jdbcType=VARCHAR},",
          "direction_id = #{directionId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}