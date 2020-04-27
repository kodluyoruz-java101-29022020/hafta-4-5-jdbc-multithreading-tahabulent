package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.Manager;

public class ManagerDAO {

	public List<Manager> loadAllActiveManagers() {

		List<Manager> managers = new ArrayList<Manager>();

		Manager manager = new Manager();

		String sql = "SELECT emp.*, dm.*,d.dept_name FROM employees emp LEFT JOIN dept_manager dm ON dm.emp_no = emp.emp_no\n"
				+ "INNER JOIN departments d ON d.dept_no=dm.dept_no where dm.to_date >= NOW()";
		ResultSet resultSet = DbSQLQuery.select(sql);

		try {

			while (resultSet.next()) {

				Employee employee = createEmployee(resultSet);
				manager.setEmployee(employee);
				manager.setDepartmentName(resultSet.getString("dept_name"));
				managers.add(manager);

			}

		} catch (Exception e) {

		}

		// Burada halen aktif olarak yöneticilik yapan tüm çalýþanlarý departman
		// isimleriyle birlikte liste halinde hazýrlayýnýz.
		// Manager sýnýfýný sizin oluþturdum.
		// Ýpucu: Bu sorgunun bir benzerini derste anlatmýþtým. Hatta
		// "sql_query_samples.sql" dosyasý içinde benzeri mevcut.

		return managers;
	}

	public Employee createEmployee(ResultSet resultSet) throws SQLException {

		Employee employee = new Employee();

		employee.setId(resultSet.getLong("emp_no"));
		employee.setName(resultSet.getString("firt_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setGender(resultSet.getString("gender"));
		employee.setBirthDate(resultSet.getDate("birthdate"));
		employee.setHireDate((resultSet.getDate("hiredate")));

		return employee;

	}

}
