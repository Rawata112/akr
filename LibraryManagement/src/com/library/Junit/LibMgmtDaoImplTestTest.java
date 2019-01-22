package com.library.Junit;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import com.library.dao.LibMgmtDaoImpl;
import com.library.entity.User;
import com.library.service.LibMgmtServiceImpl;

import junit.framework.TestCase;

public class LibMgmtDaoImplTestTest extends TestCase {
	LibMgmtServiceImpl service = new LibMgmtServiceImpl();
	LibMgmtDaoImpl dao = new LibMgmtDaoImpl();
	public void testUserAuth() throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setId("admin");
		user.setPassword("admin");
		User user1 = new User();
		user1.setId("");
		user1.setPassword("");
		assertEquals("admin", service.login(user));
		assertNotSame("",user1);
	}

	public void testShowBook() throws NullPointerException, SQLException {
		assertNotNull(service.showBook());
	}

	public void testShowBooks() throws NullPointerException, SQLException {
		assertNotNull(service.showBooks());
	}

	public void testFindBook() {
		
	}

	public void testFindUser() {
		fail("Not yet implemented");
	}

	public void testBookIssue() {
		fail("Not yet implemented");
	}

	public void testAddDays() {
		assertEquals(Date.valueOf("2019-01-02"), dao.addDays(Date.valueOf("2019-01-01"), 1));
		assertNotSame(Date.valueOf("2019-01-01"), dao.addDays(Date.valueOf("2019-01-01"), 1));
	}

	public void testIssuedBook() {
		
	}

	public void testReturnBook() {
		fail("Not yet implemented");
	}

	public void testBookNotAvailable() {
		fail("Not yet implemented");
	}

}
