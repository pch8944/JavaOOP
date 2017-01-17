package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.dto.BankDTO;

public class BankDAO {

	public BankDTO select(BankDTO dto) {
		BankDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "a65534";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			String sql = "select name,balance from bank where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				result = new BankDTO();
				result.setName(rs.getString("name"));
				result.setBalance(rs.getInt("balance"));
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();				
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}

	public BankDTO updateDeposit(BankDTO dto) {
		BankDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "a65534";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			String sql = "update bank set balance=balance+? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate();
			if( count == 1 ) {
				result = select(dto);
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
				con.close();				
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}

	public BankDTO updateWithdraw(BankDTO dto) {
		BankDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "a65534";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			String sql = "update bank set balance=balance-? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate();
			if( count == 1 ) {
				result = select(dto);
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
				con.close();				
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}
}
