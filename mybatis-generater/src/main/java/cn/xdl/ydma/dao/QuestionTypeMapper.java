package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QuestionTypeMapper {
    @Delete({
        "delete from question_type",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer typeId);

    @Insert({
        "insert into question_type (type_id, type_name)",
        "values (#{typeId,jdbcType=INTEGER}, #{typeName,jdbcType=VARCHAR})"
    })
    int insert(QuestionType record);

    @InsertProvider(type=QuestionTypeSqlProvider.class, method="insertSelective")
    int insertSelective(QuestionType record);

    @Select({
        "select",
        "type_id, type_name",
        "from question_type",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR)
    })
    QuestionType selectByPrimaryKey(Integer typeId);

    @UpdateProvider(type=QuestionTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionType record);

    @Update({
        "update question_type",
        "set type_name = #{typeName,jdbcType=VARCHAR}",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionType record);
}