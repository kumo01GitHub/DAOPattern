package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SqliteDAO extends DAO {
	private String url;

	public static final String DEFAULT_URL = "jdbc:sqlite://localhost/sqlite.db";

	public SqliteDAO(String url) throws ClassNotFoundException {
		super(DriverName.DRIVER_SQLITE);
		this.url = url;
	}

	public SqliteDAO() throws ClassNotFoundException {
		this(DEFAULT_URL);
	}

	protected void connect() throws SQLException {
		super.connect();
		setConnection(DriverManager.getConnection(url));
	}

}
