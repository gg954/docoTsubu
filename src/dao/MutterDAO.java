package dao;

/*
 * MUTTERテーブルを担当するDAO
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
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "yourPass";
	
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();
		
		//データベース接続
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//Select文を作成
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//Selectを実行
			ResultSet rs = pstmt.executeQuery();
			
			//Select文の結果をArrayListに格納
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
		//データベース接続
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//Inesrt文を作成（idは自動連番のため指定しない）
			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//Insert文中の?に使用する値を設定して、SQLを作成
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2, mutter.getText());
			
			//Insert文を実行
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
