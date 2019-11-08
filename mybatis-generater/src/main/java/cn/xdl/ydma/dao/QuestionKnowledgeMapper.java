package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.QuestionKnowledge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QuestionKnowledgeMapper {
    @Delete({
        "delete from question_knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into question_knowledge (Id, question_id, ",
        "knowledge_id)",
        "values (#{id,jdbcType=INTEGER}, #{questionId,jdbcType=INTEGER}, ",
        "#{knowledgeId,jdbcType=INTEGER})"
    })
    int insert(QuestionKnowledge record);

    @InsertProvider(type=QuestionKnowledgeSqlProvider.class, method="insertSelective")
    int insertSelective(QuestionKnowledge record);

    @Select({
        "select",
        "Id, question_id, knowledge_id",
        "from question_knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.INTEGER),
        @Result(column="knowledge_id", property="knowledgeId", jdbcType=JdbcType.INTEGER)
    })
    QuestionKnowledge selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QuestionKnowledgeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionKnowledge record);

    @Update({
        "update question_knowledge",
        "set question_id = #{questionId,jdbcType=INTEGER},",
          "knowledge_id = #{knowledgeId,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionKnowledge record);
}