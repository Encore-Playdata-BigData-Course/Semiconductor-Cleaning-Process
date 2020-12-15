package semiconductor.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import semiconductor.model.dto.Process1DTO;
import semiconductor.model.dto.Process2DTO;
import semiconductor.model.dto.TotalprocessDTO;
import semiconductor.model.util.DBUtil;

public class TotalprocessDAO {
	static Properties sql = DBUtil.getSql();
	// 사용자입장에서 보기쉽게 구현
	// 프로세스1,2의 통합적인 정보를 담고 있는 테이블 하지만 프로세스1, 2는 각 공정의 시간을 담고 있음
	// 그 시간을 일정 기준으로 공정의 실행결과를공정의 합/불/미실행 으로 변환하여 저장한 테이블

	// 합/불 판단 로직
	public static String checkpf(int minute) {
		String result = "정상";
		if (minute == 0) {
			result = "실행 전";
		} else if (minute < 13 || minute > 20) {
			result = "불량";
		}
		return result;
	}

	// insert executeUpdate사용
	public static boolean addTotalprocess(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		Process1DTO process1 = Process1DAO.getProcess1(waferId);
		Process2DTO process2 = Process2DAO.getProcess2(waferId);
		try {// 프로세스1,2의 정보를 웨이퍼id로 불러와 체크pf로 스트링변환 후 입력
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("tpro.insert"));
			pstmt.setInt(1, waferId);
			pstmt.setString(2, checkpf(process1.getClean1()));
			pstmt.setString(3, checkpf(process1.getClean2()));
			pstmt.setString(4, checkpf(process1.getRinse1()));
			pstmt.setString(5, checkpf(process2.getClean3()));
			pstmt.setString(6, checkpf(process2.getRinse2()));
			int result = pstmt.executeUpdate();
			if (result == 1) { // result == 1 ???? API에 나와있음 리턴결과는0과 1로 나옴 1은 insert, delete, update 행의 수
				return true; // 아무 리턴이 없으면 0
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// update executeUpdate사용
	public static boolean updateTotalprocess(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		Process1DTO process1 = Process1DAO.getProcess1(waferId);
		Process2DTO process2 = Process2DAO.getProcess2(waferId);
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("tpro.update"));
			pstmt.setString(1, checkpf(process1.getClean1()));
			pstmt.setString(2, checkpf(process1.getClean2()));
			pstmt.setString(3, checkpf(process1.getRinse1()));
			pstmt.setString(4, checkpf(process2.getClean3()));
			pstmt.setString(5, checkpf(process2.getRinse2()));
			pstmt.setInt(6, waferId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteTotalprocess(int waferId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("tpro.delete"));
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
