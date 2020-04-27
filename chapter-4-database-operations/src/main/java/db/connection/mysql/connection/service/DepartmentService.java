package db.connection.mysql.connection.service;

import java.util.List;

import db.connection.mysql.connection.dao.DepartmentDAO;
import db.connection.mysql.connection.model.Department;

public class DepartmentService {

	private DepartmentDAO departmentDAO;

	public DepartmentService(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public List<Department> getDepartments() {

		return departmentDAO.getAll();

	}

	public List<String> getDepartmentsByEmployeeId(Long emp_no) {

		return departmentDAO.getDepartments(emp_no);

	}

	// burada tüm departmanlarý listeleyen fonksiyonu yazýnýz.
}
