package cn.xdl.ydma.dao1;

import cn.xdl.ydma.entity1.CollectCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CollectCourseMapper {
    @Delete({
        "delete from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into collect_course (Id, user_id, ",
        "course_id, collect_time, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{collectTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(CollectCourse record);

    @InsertProvider(type=CollectCourseSqlProvider.class, method="insertSelective")
    int insertSelective(CollectCourse record);

    @Select({
        "select",
        "Id, user_id, course_id, collect_time, status",
        "from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="collectCourseMap", value={
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CollectCourse selectByPrimaryKey(Integer id);
    /**
     * 根据用户id课程id查询记录
     * @param UserId 用户id
     * @param CourseId 课程id
     * @return
     */
    @Select({
    	"select",
        "Id, user_id, course_id, collect_time, status",
        "from collect_course",
        "where user_id = #{userId,jdbcType=INTEGER} and course_id = #{courseId,jdbcType=INTEGER}"
    })
    @ResultMap("collectCourseMap")
    CollectCourse selectByUserIdAndCourseId(@Param("userId")Integer userId, @Param("courseId")Integer courseId);

    @UpdateProvider(type=CollectCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectCourse record);

    @Update({
        "update collect_course",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "collect_time = #{collectTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectCourse record);
}