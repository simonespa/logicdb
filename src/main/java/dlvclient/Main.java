package dlvclient;

import java.sql.SQLException;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NoSuchVendorException {
		try {
			DatabaseManager.init(DbVendor.MYSQL, "root", "root");
			LinkedList<String> list = DatabaseManager.getDbNames();
			for (String l : list) {
				System.out.println(l);
			}
			System.out.println();

			list = DatabaseManager.getTableNamesOf("recursive");
			for (String l : list) {
				System.out.println(l);
			}

			DatabaseManager.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
