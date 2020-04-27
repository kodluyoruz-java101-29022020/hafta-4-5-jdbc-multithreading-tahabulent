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

		// T�m departman listesini �eken SQL komutunu a�a��daki sat�ra yaz�n�z.
		ResultSet resultSet = DbSQLQuery.select("SELECT * FROM departments");

		try {

			if (resultSet == null) {
				return departments;
			}

			while (resultSet.next()) {

				Department department_temp = new Department(resultSet.getString("deptNo"), resultSet.getString("name"));

				departments.add(department_temp);

			}
			// ResultSet i�inde veritaban�ndan gelen department kay�tlar� var.
			// ResultSet �zerinde sat�r sat�r ilerleyerek bir Department listesi olu�tur.
			// List<Department> departments bu listeye elemanlar� ekleyeceksiniz.

			// Kodlar ... :)
			return departments;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return departments;

	}

	// Id ye g�re departman No'sunu veren Fonksiyon

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
