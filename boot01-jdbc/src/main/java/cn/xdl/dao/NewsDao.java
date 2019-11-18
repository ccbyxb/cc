package cn.xdl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDao {

	@Autowired
	private JdbcTemplate template;
	
}
