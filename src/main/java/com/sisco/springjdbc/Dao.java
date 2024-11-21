package com.sisco.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dao {

	@Autowired
	private DataSource dataSource;

	public void save(Employee emp) {
		System.out.println("Dao class is started..");
		try {
			Connection con = dataSource.getConnection();
			// System.out.println(con);
			PreparedStatement st = con.prepareStatement("insert into springjdbc.employee values(?,?,?,?);");
			st.setInt(1, emp.getEid());
			st.setString(2, emp.getEname());
			st.setDouble(3, emp.getEsal());
			st.setString(4, emp.getElocation());
			int n=st.executeUpdate();

			System.out.println("Data saved successfully.:" + n);

		} catch (SQLException e) {
			System.err.println("We getting Error.! from DAO save() ." + e);
		}
	}

	public void updateEmp(int eid, double esal, String elocation) {
		System.out.println("Dao started..");
		
		try {
			Connection con= dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement("update springjdbc.employee set esal=?, elocation=? where eid=?;");
			ps.setDouble(1, esal);
			ps.setString(2, elocation);
			ps.setInt(3, eid);
			int n= ps.executeUpdate();
			System.out.println("Data updated successfully.!"+n);
		
		} catch (SQLException e) {
			
		}

	}

	public void getById(int eid) {
		System.out.println("Dao started.");
		Connection con;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from springjdbc.employee where eid=?;");
			ps.setInt(1, eid);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("eid")+"--"+rs.getString("ename")+"--"+rs.getDouble("esal")+"--"+rs.getString("elocation"));
			}
			

		} catch (SQLException e) {
			System.out.println("We getting Error.! from DAO getById() ." + e);
		}

	}

	public void getAll() {
		System.out.println("Dao started.");
		try {
			Connection con= dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from springjdbc.employee;");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("eid")+"--"+rs.getString("ename")+"--"+rs.getDouble("esal")+"--"+rs.getString("elocation"));

			}
		} catch (SQLException e) {
			System.out.println("We getting Error.! from DAO getAll() ." + e);
		}
		

	}

	public void deleteById(int eid) {
		System.out.println("Dao started.");
	try {
		Connection con=	dataSource.getConnection();
		PreparedStatement ps= con.prepareStatement("delete from springjdbc.employee where eid=?;");
		ps.setInt(1, eid);
		int n= ps.executeUpdate();
		System.out.println("Deleted one record: "+n);
	
	} catch (SQLException e) {
		System.out.println("We getting Error.! from DAO getAll() ." + e);

	}
	}

}
