package semiconductor.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import semiconductor.model.dto.Process2DTO;
import semiconductor.model.util.DBUtil;

public class Process2DAO {
	static Properties sql = DBUtil.getSql();

	// wafer id 저장
	public static boolean addProcess2(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro2.insert"));
			pstmt.setInt(1, waferId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// waferid로 clean3 수정
	public static boolean updateClean3(int waferId, int clean3) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("pro2.updateClean3"));
			pstmt.setInt(1, clean3);
			pstmt.setInt(2, waferId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				TotalprocessDAO.updateTotalprocess(waferId);
				UiDAO.updateUi(waferId);
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// waferid로 rinse2 수정
	public static boolean updateRinse2(int waferId, int rinse2) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("pro2.updateRinse2"));
			pstmt.setInt(1, rinse2);
			pstmt.setInt(2, waferId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				TotalprocessDAO.updateTotalprocess(waferId);
				UiDAO.updateUi(waferId);
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제
	// wafer id로 process2 삭제
	// 프로세스2 삭제 가능 왜?????? fk인디??? 프로세스1,2 데이터 불일치 뭐지 프로세스2 전체업데이트 됨??
	public static boolean deleteProcess2(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro2.delete"));
			pstmt.setInt(1, waferId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// wafer id로 해당 process2 검색
	public static Process2DTO getProcess2(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Process2DTO process2 = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro2.getProcess2"));
			pstmt.setInt(1, waferId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				process2 = new Process2DTO(rset.getInt(1), rset.getInt(2), rset.getInt(3));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return process2;
	}

	// 모든 프로세스2 검색
	public static ArrayList<Process2DTO> getAllProcess2() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Process2DTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("pro2.All"));
			rset = pstmt.executeQuery();

			list = new ArrayList<Process2DTO>();
			while (rset.next()) {
				list.add(new Process2DTO(rset.getInt(1), rset.getInt(2), rset.getInt(3)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}
