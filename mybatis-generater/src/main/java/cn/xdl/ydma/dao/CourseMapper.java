package cn.xdl.ydma.dao;

import cn.xdl.ydma.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course (id, name, ",
        "intro, learn_count, ",
        "difficulty, score, ",
        "image, publish_time, ",
        "price, subject_id, ",
        "direction_id, learn_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{learnCount,jdbcType=INTEGER}, ",
        "#{difficulty,jdbcType=VARCHAR}, #{score,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{price,jdbcType=INTEGER}, #{subjectId,jdbcType=INTEGER}, ",
        "#{directionId,jdbcType=INTEGER}, #{learnTime,jdbcType=INTEGER})"
    })
    int insert(Course record);

    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "learn_count = #{learnCount,jdbcType=INTEGER},",
          "difficulty = #{difficulty,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "price = #{price,jdbcType=INTEGER},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "direction_id = #{directionId,jdbcType=INTEGER},",
          "learn_time = #{learnTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}