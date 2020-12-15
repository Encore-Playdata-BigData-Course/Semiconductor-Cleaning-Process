package semiconductor.service;

import java.sql.SQLException;
import java.util.ArrayList;

import semiconductor.exception.NotExistException;
import semiconductor.model.Process1DAO;
import semiconductor.model.Process2DAO;
import semiconductor.model.TotalprocessDAO;
import semiconductor.model.UiDAO;
import semiconductor.model.dto.Process1DTO;
import semiconductor.model.dto.Process2DTO;

public class ProcessService {
	private static ProcessService instance = new ProcessService();

	private ProcessService() {
	}

	public static ProcessService getInstance() {
		return instance;
	}

	// semiconductor CRUD, 싱글톤 패턴으로 모든 서비스를 DAO받아 구현했음

	// Process1
	public static void notExistSemi1(int waferId) throws NotExistException, SQLException {
		Process1DTO process1 = Process1DAO.getProcess1(waferId);
		if (process1 == null) {
			throw new NotExistException("선택하신 wafer가 존재하지 않습니다.");
		}
	}

	// 모든 process1 정보 반환
	public static ArrayList<Process1DTO> getAllProcess1() throws SQLException {
		return Process1DAO.getAllProcess1();
	}

	// waferId로 검색
	public static Process1DTO getProcess1(int waferId) throws NotExistException, SQLException {
		Process1DTO process1 = Process1DAO.getProcess1(waferId);
		if (process1 == null) {
			throw new NotExistException("선택하신 wafer가 존재하지 않습니다.");
		}
		return process1;
	}

	// process1 저장
	public static boolean addProcess(int waferId) throws SQLException {
		return Process1DAO.addProcess(waferId);
	}

	// process1 삭제
	public static boolean deleteProcess(int waferId) throws NotExistException, SQLException {
		notExistSemi1(waferId);
		return Process1DAO.deleteProcess(waferId);
	}

	// process1의 clean1 수정
	public static boolean updateClean1(int waferId, int minute) throws NotExistException, SQLException {
		notExistSemi1(waferId);
		return Process1DAO.updateClean1(waferId, minute);
	}

	// process1의 clean2 수정
	public static boolean updateClean2(int waferId, int minute) throws NotExistException, SQLException {
		notExistSemi1(waferId);
		return Process1DAO.updateClean2(waferId, minute);
	}

	// process1의 rinse1 수정
	public static boolean updateRinse1(int waferId, int minute) throws NotExistException, SQLException {
		notExistSemi1(waferId);
		return Process1DAO.updateRinse1(waferId, minute);
	}

	// Process2
	public static void notExistSemi2(int waferId) throws NotExistException, SQLException {
		Process2DTO Process2 = Process2DAO.getProcess2(waferId);
		if (Process2 == null) {
			throw new NotExistException("선택하신 wafer가 존재하지 않습니다.");
		}
	}

	// 모든 Process2 정보 반환
	public static ArrayList<Process2DTO> getAllProcess2() throws SQLException {
		return Process2DAO.getAllProcess2();
	}

	// waferId로 검색
	public static Process2DTO getProcess2(int waferId) throws NotExistException, SQLException {
		Process2DTO Process2 = Process2DAO.getProcess2(waferId);
		if (Process2 == null) {
			throw new NotExistException("선택하신 wafer가 존재하지 않습니다.");
		}
		return Process2;
	}

	// Process2 저장
//  public static boolean addProcess2(int waferId) throws SQLException{
//    return Process2DAO.addProcess2(waferId);
//  }

	// Process2 삭제
//  public static boolean deleteProcess2(int waferId) throws NotExistException, SQLException{
//    notExistSemi2(waferId);
//    return Process2DAO.deleteProcess2(waferId);
//  }

	// Process2의 clean3 수정
	public static boolean updateClean3(int waferId, int minute) throws NotExistException, SQLException {
		notExistSemi2(waferId);
		return Process2DAO.updateClean3(waferId, minute);
	}

	// Process2의 rinse2 수정
	public static boolean updateRinse2(int waferId, int minute) throws NotExistException, SQLException {
		notExistSemi2(waferId);
		return Process2DAO.updateRinse2(waferId, minute);
	}

	// Ui
	// Ui 저장
//	public static boolean addui(int waferId) throws SQLException{
//		return UiDAO.addui(waferId);
//	}

	// ui 수정
	public static boolean updateUi(int waferId) throws SQLException {
		return UiDAO.updateUi(waferId);
	}

	// Totalprocess
	// totalprocess 저장
//	public static boolean addTotalprocess(int waferId) throws SQLException{
//		return TotalprocessDAO.addTotalprocess(waferId);
//	}

	// totalprocess 수정
	public static boolean updateTotalprocess(int waferId) throws SQLException {
		return TotalprocessDAO.updateTotalprocess(waferId);
	}
}
