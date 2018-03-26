package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class PostgresqlDAO extends DAO {
	private String url;
	private String user;
	private String password;

	public static final String DEFAULT_URL = "jdbc:postgresql://localhost/postgresql";
	public static final String DEFAULT_USER = "root";
	public static final String DEFAULT_PASSWORD = "password";

	public PostgresqlDAO(String url, String user, String password) throws ClassNotFoundException {
		super(DriverName.DRIVER_POSTGRESQL);
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public PostgresqlDAO() throws ClassNotFoundException {
		this(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
	}

	protected void connect() throws SQLException {
		super.connect();
		setConnection(DriverManager.getConnection(url, user, password));
	}

}
