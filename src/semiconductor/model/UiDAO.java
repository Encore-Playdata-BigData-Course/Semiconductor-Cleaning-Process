package semiconductor.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import semiconductor.model.util.DBUtil;

public class UiDAO {
	static Properties sql = DBUtil.getSql();
	// UiDAO 사용자가 공정 오류 및 결과를 한눈에 파악할수 있도록 하는 테이블입니다.

	// insert 직접적으로 안씀 >> 프로세스1에서 웨이퍼id생성 순간 전체적으로 다 생성시키기 위해 사용
	// insert
	public static boolean addui(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("ui.insert"));
			pstmt.setInt(1, waferId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static String processN(int i) {
		String p = "정상";
		if (i == 2) {// i=totalprocess의 컬럼인덱스값을 공정 이름으로 바꿔주는 역할
			p = "Clean1";
		} else if (i == 3) {
			p = "Clean2";
		} else if (i == 4) {
			p = "Rinse1";
		} else if (i == 5) {
			p = "Clean3";
		} else if (i == 6) {
			p = "Rinse2";
		}
		return p;
	}

	// update
	// 기존 정보를 수정해주는것이 아닌 토탈프로세스 데이터를 시각화하는 작업
	public static boolean updateUi(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		ResultSet rset3 = null;
		try {
			con = DBUtil.getConnection();
			pstmt1 = con.prepareStatement(sql.getProperty("tpro.getTotalprocess"));
			pstmt2 = con.prepareStatement(sql.getProperty("ui.updateResult"));
			pstmt3 = con.prepareStatement(sql.getProperty("ui.updateerrorpoint"));
			pstmt1.setInt(1, waferId);
			rset = pstmt1.executeQuery();// 특정 웨이퍼id의 토탈프로세스 정보 검색 (토탈프로세스에서 보여준 스트링값(정상,불량,실행전)
			if (rset.next()) {// rset은 쿼리문 실행, select(get)할 때 사용
				for (int i = 2; i < 7; i++) {// totalprocess의 컬럼순서
					if (rset.getString(i).equals("불량")) {
						pstmt2.setString(1, "불량");
						pstmt2.setInt(2, waferId);
						pstmt3.setString(1, processN(i)); // i라는 인덱스의 컬럼명을 ui errorpoint 값으로 지정
						pstmt3.setInt(2, waferId);
						break;
					} else if (rset.getString(i).equals("실행 전")) {
						pstmt2.setString(1, "실행 전");
						pstmt2.setInt(2, waferId);
						pstmt3.setString(1, processN(i));
						pstmt3.setInt(2, waferId);
						break;
					} else {
						pstmt2.setString(1, "정상");
						pstmt2.setInt(2, waferId);
						pstmt3.setString(1, "전과정성공");
						pstmt3.setInt(2, waferId);
					} // 마지막에 전과정성공 여부를 판단해야하기 때문에 break없음
				}
				rset2 = pstmt2.executeQuery(); // ui업데이트
				rset3 = pstmt3.executeQuery(); // ui 에러포인트 업데이트 시연은 직접 보여줌
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt1);
			DBUtil.close(con, pstmt2);
			DBUtil.close(con, pstmt3);
		}
		return false;
	}

	// delete
	public static boolean deleteUi(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("ui.delete"));
			pstmt.setInt(1, waferId);
			int result = pstmt.executeUpdate(); // CUD에 executeUpdate 사용
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt); // 질문 프로세스1 웨이퍼아이디 지움 > 나머지 자동삭제 원리 물어봐라 선생님들한테
		}
		return false;
	}

}
