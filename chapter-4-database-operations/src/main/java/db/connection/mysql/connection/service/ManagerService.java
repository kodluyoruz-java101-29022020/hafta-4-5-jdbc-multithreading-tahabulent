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
	// buraya aktif yÃ¶neticileri listeleyen bir fonksiyon yazÄ±nÄ±z.

}

/*
 * "1- Tüm çalýþan listesi "); "2- Çalýþan profili sorgulama ");
 * "3- Yeni çalýþan ekleme "); "4- Çalýþan verilerini güncelleme ");
 * "5- Çalýþan silme "); "6- Menüyü tekrar yazdýr ");
 * "7- Aktif yöneticilik yapanlarý listele "); ("8- Departmanlarý listele ");
 * "9- Çýkýþ ");
 */