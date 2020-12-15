package semiconductor.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import semiconductor.model.dto.Process1DTO;
import semiconductor.model.util.DBUtil;

public class Process1DAO {
	static Properties sql = DBUtil.getSql();

	// insert
	// 프로세스1에 웨이퍼id추가(통합관리) >>나머지 테이블에도 동시에 생성
	// rset사용안함
	public static boolean addProcess(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro1.insert"));
			pstmt.setInt(1, waferId);

			int result = pstmt.executeUpdate();// CUD에 executeUpdate 사용

			if (result == 1) {
				Process2DAO.addProcess2(waferId);
				TotalprocessDAO.addTotalprocess(waferId);
				UiDAO.addui(waferId);
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// update
	// 웨이퍼id로 클린1 공정 수정 마찬가지로 토탈/ui 둘다 업데이트
	public static boolean updateClean1(int waferId, int minute) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("pro1.updateClean1"));
			pstmt.setInt(1, minute);
			pstmt.setInt(2, waferId);

			int result = pstmt.executeUpdate();// CUD에 executeUpdate 사용
			if (result == 1) {
				TotalprocessDAO.updateTotalprocess(waferId);
				UiDAO.updateUi(waferId);
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// update
	// 웨이퍼id로 클린2 공정 수정 마찬가지로 토탈/ui 둘다 업데이트
	public static boolean updateClean2(int waferId, int minute) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("pro1.updateClean2"));
			pstmt.setInt(1, minute);
			pstmt.setInt(2, waferId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				TotalprocessDAO.updateTotalprocess(waferId);
				UiDAO.updateUi(waferId);
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// update
	// 린스1 공정 수정 마찬가지로 토탈/ui 둘다 업데이트
	public static boolean updateRinse1(int waferId, int minute) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("pro1.updateRinse1"));
			pstmt.setInt(1, minute);
			pstmt.setInt(2, waferId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				TotalprocessDAO.updateTotalprocess(waferId);
				UiDAO.updateUi(waferId);
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// delete
	// 해당 웨이퍼id 통합관리를 하기때문에 삭제
	public static boolean deleteProcess(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro1.delete"));
			pstmt.setInt(1, waferId);
			int result = pstmt.executeUpdate(); // CUD에 executeUpdate 사용
			if (result == 1) {
				Process2DAO.deleteProcess2(waferId);
				TotalprocessDAO.deleteTotalprocess(waferId);
				UiDAO.deleteUi(waferId);
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

	// select
	// 웨이퍼id로 프로세스1 공정 검색
	public static Process1DTO getProcess1(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; // get을 썼으므로 resultset사용
		Process1DTO process1 = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro1.getProcess1"));
			pstmt.setInt(1, waferId);
			rset = pstmt.executeQuery(); // rset사용 >> executeQuery씀
			if (rset.next()) {
				process1 = new Process1DTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return process1;
	}

	// select
	// 모든 프로세스1의 정보를 검색 getAll
	// 대충암 사실 잘모름 물어봐야댐 해결
	public static ArrayList<Process1DTO> getAllProcess1() throws SQLException {
		Connection con = null;
		Statement stmt = null; // sql쿼리에 ? 즉 특정 변수(?)값이 안들어가므로 statement사용
		ResultSet rset = null; // get쓰므로 resultset사용

		ArrayList<Process1DTO> datas = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement(); // stmt사용
			rset = stmt.executeQuery(sql.getProperty("pro1All"));
			datas = new ArrayList<>();
			while (rset.next()) {
				datas.add(new Process1DTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return datas;
	}
}
