package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;

public class DepartmentDAO {

	private static final Logger logger = Logger.getLogger(DepartmentDAO.class);

	public List<Department> getAll() {

		List<Department> departments = new ArrayList<Department>();

		// Tüm departman listesini çeken SQL komutunu aþaðýdaki satýra yazýnýz.
		ResultSet resultSet = DbSQLQuery.select("SELECT * FROM departments");

		try {

			if (resultSet == null) {
				return departments;
			}

			while (resultSet.next()) {

				Department department_temp = new Department(resultSet.getString("deptNo"), resultSet.getString("name"));

				departments.add(department_temp);

			}
			// ResultSet içinde veritabanýndan gelen department kayýtlarý var.
			// ResultSet üzerinde satýr satýr ilerleyerek bir Department listesi oluþtur.
			// List<Department> departments bu listeye elemanlarý ekleyeceksiniz.

			// Kodlar ... :)
			return departments;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return departments;

	}

	// Id ye göre departman No'sunu veren Fonksiyon

	public List<String> getDepartments(Long emp_no) {

		String sql = "SELECT dp.dept_name FROM dept_emp d INNER JOIN departments dp ON d.dept_no=dp.dept_no WHERE emp_no="
				+ emp_no;
		ResultSet resultSet = DbSQLQuery.select(sql);

		List<String> departments = new ArrayList<String>();

		try {

			while (resultSet.next()) {

				departments.add(resultSet.getString("dept_name"));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return departments;

	}

}
