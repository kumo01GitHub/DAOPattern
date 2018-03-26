package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MysqlDAO extends DAO {
	private String url;
	private String user;
	private String password;

	public static final String DEFAULT_URL = "jdbc:mysql://localhost/mysql";
	public static final String DEFAULT_USER = "root";
	public static final String DEFAULT_PASSWORD = "password";

	public MysqlDAO(String url, String user, String password) throws ClassNotFoundException {
		super(DriverName.DRIVER_MYSQL);
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public MysqlDAO() throws ClassNotFoundException {
		this(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
	}

	protected void connect() throws SQLException {
		super.connect();
		setConnection(DriverManager.getConnection(url, user, password));
	}

}
