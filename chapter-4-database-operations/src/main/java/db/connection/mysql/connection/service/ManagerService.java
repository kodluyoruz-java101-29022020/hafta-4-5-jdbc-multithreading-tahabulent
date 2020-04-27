package db.connection.mysql.connection.service;

import java.util.List;

import db.connection.mysql.connection.dao.ManagerDAO;
import db.connection.mysql.connection.model.Manager;

public class ManagerService {

	private ManagerDAO managerDAO;

	public ManagerService(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	public List<Manager> getAllActiveManagers() {

		return managerDAO.loadAllActiveManagers();

	}
	// buraya aktif yöneticileri listeleyen bir fonksiyon yazınız.

}

/*
 * "1- T�m �al��an listesi "); "2- �al��an profili sorgulama ");
 * "3- Yeni �al��an ekleme "); "4- �al��an verilerini g�ncelleme ");
 * "5- �al��an silme "); "6- Men�y� tekrar yazd�r ");
 * "7- Aktif y�neticilik yapanlar� listele "); ("8- Departmanlar� listele ");
 * "9- ��k�� ");
 */