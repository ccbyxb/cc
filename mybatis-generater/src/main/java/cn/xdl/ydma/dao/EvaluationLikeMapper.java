package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.EvaluationLike;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EvaluationLikeMapper {
    @Delete({
        "delete from evaluation_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into evaluation_like (Id, evaluation_id, ",
        "user_id, like_time)",
        "values (#{id,jdbcType=INTEGER}, #{evaluationId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{likeTime,jdbcType=TIMESTAMP})"
    })
    int insert(EvaluationLike record);

    @InsertProvider(type=EvaluationLikeSqlProvider.class, method="insertSelective")
    int insertSelective(EvaluationLike record);

    @Select({
        "select",
        "Id, evaluation_id, user_id, like_time",
        "from evaluation_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="evaluation_id", property="evaluationId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="like_time", property="likeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    EvaluationLike selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EvaluationLikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EvaluationLike record);

    @Update({
        "update evaluation_like",
        "set evaluation_id = #{evaluationId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "like_time = #{likeTime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EvaluationLike record);
}