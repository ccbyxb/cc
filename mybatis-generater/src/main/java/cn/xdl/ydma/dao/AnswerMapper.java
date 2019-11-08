package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Answer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AnswerMapper {
    @Delete({
        "delete from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into answer (id, context, ",
        "publish_time, issue_id, ",
        "user_id)",
        "values (#{id,jdbcType=INTEGER}, #{context,jdbcType=VARCHAR}, ",
        "#{publishTime,jdbcType=TIMESTAMP}, #{issueId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    int insert(Answer record);

    @InsertProvider(type=AnswerSqlProvider.class, method="insertSelective")
    int insertSelective(Answer record);

    @Select({
        "select",
        "id, context, publish_time, issue_id, user_id",
        "from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_id", property="issueId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Answer selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AnswerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Answer record);

    @Update({
        "update answer",
        "set context = #{context,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "issue_id = #{issueId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Answer record);
}