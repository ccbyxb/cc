package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.PaperQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaperQuestionMapper {
    @Delete({
        "delete from paper_question",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperId);

    @Insert({
        "insert into paper_question (paper_id, question_id, ",
        "question_score)",
        "values (#{paperId,jdbcType=INTEGER}, #{questionId,jdbcType=INTEGER}, ",
        "#{questionScore,jdbcType=INTEGER})"
    })
    int insert(PaperQuestion record);

    @InsertProvider(type=PaperQuestionSqlProvider.class, method="insertSelective")
    int insertSelective(PaperQuestion record);

    @Select({
        "select",
        "paper_id, question_id, question_score",
        "from paper_question",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.INTEGER),
        @Result(column="question_score", property="questionScore", jdbcType=JdbcType.INTEGER)
    })
    PaperQuestion selectByPrimaryKey(Integer paperId);

    @UpdateProvider(type=PaperQuestionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperQuestion record);

    @Update({
        "update paper_question",
        "set question_id = #{questionId,jdbcType=INTEGER},",
          "question_score = #{questionScore,jdbcType=INTEGER}",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperQuestion record);
}