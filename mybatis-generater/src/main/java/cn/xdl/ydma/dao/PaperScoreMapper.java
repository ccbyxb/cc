package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.PaperScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaperScoreMapper {
    @Delete({
        "delete from paper_score",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into paper_score (Id, total_score, ",
        "my_score, start_time, ",
        "end_time, paper_id, ",
        "user_id)",
        "values (#{id,jdbcType=INTEGER}, #{totalScore,jdbcType=INTEGER}, ",
        "#{myScore,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{paperId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    int insert(PaperScore record);

    @InsertProvider(type=PaperScoreSqlProvider.class, method="insertSelective")
    int insertSelective(PaperScore record);

    @Select({
        "select",
        "Id, total_score, my_score, start_time, end_time, paper_id, user_id",
        "from paper_score",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="total_score", property="totalScore", jdbcType=JdbcType.INTEGER),
        @Result(column="my_score", property="myScore", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    PaperScore selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PaperScoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperScore record);

    @Update({
        "update paper_score",
        "set total_score = #{totalScore,jdbcType=INTEGER},",
          "my_score = #{myScore,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "paper_id = #{paperId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperScore record);
}