package org.education;

import java.sql.SQLException;

import javax.sql.DataSource;

public class DAOFactory {
	private DataSource dataSource;

	public DAOFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public GroupDAO newGroupDAO() throws SQLException {
		return new GroupDAO(dataSource.getConnection());
	}
}
