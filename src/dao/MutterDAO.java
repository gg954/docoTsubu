package dao;

/*
 * MUTTER�e�[�u����S������DAO
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

public class MutterDAO {
	//�f�[�^�x�[�X�ڑ��Ɏg�p������
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "Ed1s0n";
	
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();
		
		//�f�[�^�x�[�X�ڑ�
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//Select�����쐬
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//Select�����s
			ResultSet rs = pstmt.executeQuery();
			
			//Select���̌��ʂ�ArrayList�Ɋi�[
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		//�f�[�^�x�[�X�ڑ�
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//Inesrt�����쐬�iid�͎����A�Ԃ̂��ߎw�肵�Ȃ��j
			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//Insert������?�Ɏg�p����l��ݒ肵�āASQL���쐬
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2, mutter.getText());
			
			//Insert�������s
			int result = pstmt.executeUpdate();
			if(result != 1) {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
