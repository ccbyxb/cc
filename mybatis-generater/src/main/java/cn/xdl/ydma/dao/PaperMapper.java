package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaperMapper {
    @Delete({
        "delete from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperId);

    @Insert({
        "insert into paper (paper_id, type_id, ",
        "user_id, subject_id, ",
        "score, limit_time, ",
        "createtime, begintime, ",
        "endtime, status, ",
        "question_total, name)",
        "values (#{paperId,jdbcType=INTEGER}, #{typeId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{subjectId,jdbcType=INTEGER}, ",
        "#{score,jdbcType=INTEGER}, #{limitTime,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{begintime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{questionTotal,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Paper record);

    @InsertProvider(type=PaperSqlProvider.class, method="insertSelective")
    int insertSelective(Paper record);

    @Select({
        "select",
        "paper_id, type_id, user_id, subject_id, score, limit_time, createtime, begintime, ",
        "endtime, status, question_total, name",
        "from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_time", property="limitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="begintime", property="begintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endtime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="question_total", property="questionTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Paper selectByPrimaryKey(Integer paperId);

    @UpdateProvider(type=PaperSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Paper record);

    @Update({
        "update paper",
        "set type_id = #{typeId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=INTEGER},",
          "limit_time = #{limitTime,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "begintime = #{begintime,jdbcType=TIMESTAMP},",
          "endtime = #{endtime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "question_total = #{questionTotal,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Paper record);
}