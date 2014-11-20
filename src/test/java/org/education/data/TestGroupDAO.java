package org.education.data;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.sql.DataSource;


import org.education.DAOFactory;
import org.education.Group;
import org.education.GroupDAO;
import org.hsqldb.jdbc.JDBCDataSource;
import org.testng.annotations.*;

public class TestGroupDAO {
	//private DataSource dataSource;
	private Connection connection;
	private PreparedStatement clean;
	private PreparedStatement select;
	private GroupDAO dao;
	private DAOFactory daoFactory;
	
	private List<Group> selectAll() throws SQLException {
		List<Group> list = new ArrayList<Group>();
		ResultSet result = select.executeQuery();
		while(result.next()) {
			Group group = new Group();
			group.setId(result.getInt(1));
			group.setNumber(result.getString(2));
			group.setFaculty(result.getString(3));
			list.add(group);
		}
		return list;
	}
	
	@BeforeClass
	public void beforeClass() throws SQLException {
		JDBCDataSource hsqldbSource = new JDBCDataSource();
		hsqldbSource.setDatabase("jdbc:hsqldb:file:"+System.getProperty("targetDirectory"));
		hsqldbSource.setUser("SA");		
		
		daoFactory = new DAOFactory(hsqldbSource);
		
		connection = hsqldbSource.getConnection();
		clean = connection.prepareStatement("delete from \"group\";");
		select = connection.prepareStatement("select * from \"group\";");
	}
	
	@BeforeMethod
	public void beforeMethod() throws SQLException {
		clean.execute();
		dao = daoFactory.newGroupDAO();
	}
	
	@Test
	public void testSelectAll() {
		dao.selectAll();
	}
	
	@AfterMethod
	public void afterMethod() throws SQLException {
		clean.execute();
	}
	
	@AfterClass
	public void afterClass() throws SQLException {
		connection.close();
	}
}
