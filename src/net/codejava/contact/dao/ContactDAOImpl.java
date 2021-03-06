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
		
		System.out.println("ContactDAOImpl linea 23 - this.jdbcTemplate - constructor");
	}
	
	@Override
	public int save(Contact c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO contact (name, email, address, phone) VALUES (?,?,?,?)";
		System.out.println("ContactDAOImpl linea 30 - save");
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(), c.getAddress(),c.getPhone());
	}

	@Override
	public int update(Contact c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE contact SET name=?, email=?,address=?,phone=? WHERE contact_id=?";
		System.out.println("ContactDAOImpl linea 38 - updatesave");
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(), c.getAddress(),c.getPhone(),c.getId());

	}

	@Override
	public Contact get(final Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM contact WHERE contact_id="+ id;
		System.out.println("ContactDAOImpl linea 47 - inicio - get");
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
		System.out.println("ContactDAOImpl linea 66 - inicio - get");
		return jdbcTemplate.query(sql,extractor);

	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact WHERE contact_id="+ id;
		System.out.println("ContactDAOImpl linea 74 - delete");
		return jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Contact> list() {
		System.out.println("ContactDAOImpl linea 81 - inicio List");
		
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
		System.out.println("ContactDAOImpl linea 97 - fin List");
		return jdbcTemplate.query(sql,rowMapper);
			
	}

}
