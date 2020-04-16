package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import jbr.springmvc.model.Pan;
@Service
public class PANDaoImpl implements PANDao {

	 @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;

	  public int register(Pan pan) {
	    String sql = "insert into pancardscore values(?,?)";
	    return jdbcTemplate.update(sql, new Object[] { pan.getPanNo(), pan.getScore() });
	  }

	  public Pan validatePan(Pan pan) {
	    String sql = "select * from pancardscore where pancard= ?";
	    Pan processPan = null;
	    try {
			 processPan = jdbcTemplate.queryForObject(sql, new Object[] {pan.getPanNo()}, new PanMapper());
		} catch (EmptyResultDataAccessException  e) {
			return null;
		}	    
	    return processPan;
	  }

}

	class PanMapper implements RowMapper<Pan> {

	  public Pan mapRow(ResultSet rs, int arg1) throws SQLException {
	    Pan pan = new Pan();

	    pan.setPanNo(rs.getString("pancard"));
	    pan.setScore(rs.getDouble("score"));
	    return pan;
	  }
	}