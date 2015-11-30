package com.apress.isf.spring.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apress.isf.java.model.Document;

@Repository("documentDAO")//어노테이션으로 데이터베이스와 엑세스
public class DocumentRepository implements DocumentDAO {

	@Autowired//클래스와 빈을 자동으로연결
	private DataSource dataSource;
	@Autowired
	private String query;

	public List<Document> getAll() {
		return new JdbcTemplate(this.dataSource).query(query, new DocumentRowMapper());
	}

}
