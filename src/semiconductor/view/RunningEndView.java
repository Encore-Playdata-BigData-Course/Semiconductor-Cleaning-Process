package semiconductor.view;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j;
import semiconductor.model.dto.Process1DTO;
import semiconductor.model.dto.Process2DTO;

@Log4j
public class RunningEndView {
	
	// 모든 프로세스1 리스트출력
	public static void process1ListView(ArrayList<Process1DTO> allprocess1) {

		int length = allprocess1.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allprocess1.get(index));
				log.info("검색정보 " + (index + 1) + " - " + allprocess1.get(index));
			}
		}
	}

	public static void process2ListView(ArrayList<Process2DTO> allprocess2) {
		// ? 데이터 수가 몇만건
		// 하단 코드 적합 부적합 고민
		int length = allprocess2.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allprocess2.get(index));
				log.info("검색정보 " + (index + 1) + " - " + allprocess2.get(index));
			}
		}
	}

	// 특정 process1 출력
	public static void process1View(Process1DTO process1) {
		System.out.println(process1);
		log.info(process1);
		
	}

	// 특정 process2 출력
	public static void process2View(Process2DTO process2) {
		System.out.println(process2);
		log.info(process2);
	}

	// ?? 모든 process 정보 출력하는 메소드
	public static void allView(Object object) {
		System.out.println(object);
		log.info(object);
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
		log.info(message);
	}
}