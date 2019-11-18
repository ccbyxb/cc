package cn.xdl;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.xdl.entity.DbParams;
import cn.xdl.entity.DbParams1;

//@EnableAutoConfiguration//包含了@EnableConfigurationProperties功能
@SpringBootApplication
public class RunBoot {
	
	
	
	@Bean
	@ConfigurationProperties
	public DbParams dbParams() {
		return new DbParams();
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RunBoot.class, args);
		DataSource ds = ac.getBean("dataSource",DataSource.class);
		System.out.println(ds);
		JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println(template);
		DbParams params = ac.getBean(DbParams.class);
		System.out.println(params.getName()+" "+params.getSex());
		DbParams1 params1 = ac.getBean(DbParams1.class);
		System.out.println(params1.getUsername()+" "+params1.getPassword());
		System.out.println(params1.getUrl());
	}

}
