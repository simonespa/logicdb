package dlvclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatabaseManager {

	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String getUrl(DbVendor vendor, String host, String port) {
		StringBuilder urlBuilder = new StringBuilder("jdbc:");
		if (vendor.equals(DbVendor.MYSQL)) {
			urlBuilder.append("mysql://");
		} else if (vendor.equals(DbVendor.POSTGRESQL)) {
			urlBuilder.append("postgresql://");
		}
		if (host != null && !host.equals("")) {
			urlBuilder.append(host);
		}
		if (port != null && !port.equals("")) {
			urlBuilder.append(":").append(port);
		}
		return urlBuilder.toString();
	}

	public static void init(DbVendor vendor, String username, String password)
			throws SQLException, NoSuchVendorException {
		init(vendor, null, null, username, password);
	}

	public static void init(DbVendor vendor, String host, String port, String username, String password)
			throws SQLException, NoSuchVendorException {
		if (vendor == null)
			throw new NoSuchVendorException();
		String url = getUrl(vendor, host, port);
		connection = DriverManager.getConnection(url, username, password);
	}

	public static void clear() throws SQLException {
		connection.close();
	}

	public static LinkedList<String> getDbNames() throws SQLException {
		ResultSet result = connection.getMetaData().getCatalogs();
		LinkedList<String> dbNameList = new LinkedList<>();
		while (result.next()) {
			dbNameList.add(result.getString(1));
		}
		return dbNameList;
	}

	public static LinkedList<String> getTableNamesOf(String dbName) throws SQLException {
		ResultSet result = connection.getMetaData().getTables(dbName, null, "%", null);
		LinkedList<String> tableNameList = new LinkedList<>();
		while (result.next()) {
			tableNameList.add(result.getString(3));
		}
		return tableNameList;
	}

}
