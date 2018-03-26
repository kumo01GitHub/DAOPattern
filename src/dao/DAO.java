package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTO;

public abstract class DAO {
	private Connection connection;
	private ArrayList<PreparedStatement> stmts;

	public DAO(String drivername) throws ClassNotFoundException {
		Class.forName(drivername);
	}

	protected void connect() throws SQLException {
		stmts = new ArrayList<PreparedStatement>();
	}

	protected void close() throws SQLException {
		if (stmts != null) {
			for (int i = 0; i < stmts.size(); i++) {
				PreparedStatement stmt = stmts.get(i);
				if (stmt != null) {
					stmt.close();
				}
			}
		}
		if (connection != null) {
			connection.close();
		}
	}

	protected PreparedStatement prepareStatement(String sql) throws SQLException {
		if (connection != null) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmts.add(stmt);
			return stmt;
		} else {
			return null;
		}
	}

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

	public abstract void insert(DTO dto);
	public abstract void delete();
	public abstract void delete(Object key);
	public abstract void update(DTO dto);
	public abstract DTO select(Object key);
	public abstract ArrayList<DTO> select();

}
