package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionOptions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QuestionOptionsMapper {
    @Delete({
        "delete from question_options",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer optionId);

    @Insert({
        "insert into question_options (option_id, question_id, ",
        "option_name)",
        "values (#{optionId,jdbcType=INTEGER}, #{questionId,jdbcType=INTEGER}, ",
        "#{optionName,jdbcType=VARCHAR})"
    })
    int insert(QuestionOptions record);

    @InsertProvider(type=QuestionOptionsSqlProvider.class, method="insertSelective")
    int insertSelective(QuestionOptions record);

    @Select({
        "select",
        "option_id, question_id, option_name",
        "from question_options",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="option_id", property="optionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.INTEGER),
        @Result(column="option_name", property="optionName", jdbcType=JdbcType.VARCHAR)
    })
    QuestionOptions selectByPrimaryKey(Integer optionId);

    @UpdateProvider(type=QuestionOptionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionOptions record);

    @Update({
        "update question_options",
        "set question_id = #{questionId,jdbcType=INTEGER},",
          "option_name = #{optionName,jdbcType=VARCHAR}",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionOptions record);
}