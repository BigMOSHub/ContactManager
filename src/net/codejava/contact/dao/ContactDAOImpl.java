package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public int save(Contact c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO contact (name, email, address, phone) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(), c.getAddress(),c.getPhone());
	}

	@Override
	public int update(Contact c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE contact SET name=?, email=?,address=?,phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(), c.getAddress(),c.getPhone(),c.getId());

	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM contact WHERE contact_id="+ id;
		
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					return new Contact(id,name,email,address,phone);
					
				}
				
				return null;
			}
			
		};

		return jdbcTemplate.query(sql,extractor);

	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact WHERE contact_id="+ id;
		return jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Contact> list() {

		String sql = "SELECT * FROM contact";
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Contact(id,name,email,address,phone);
			}
			
		};
		return jdbcTemplate.query(sql,rowMapper);
		
	}

}
