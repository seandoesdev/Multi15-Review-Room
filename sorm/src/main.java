import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sorm.DTO.placeDTO;
import com.sorm.Service.clientService;

@classPreamble(
		author = "Sean Kim",
		date = "08/05/2023",
		currentRevision = "1.0.0",
		lastModified ="08/06/2023",
		lastModifiedBy="Sean kim"
	)

public class main {

	public static boolean signIn() throws Exception {
		
		boolean isCreated = true;
		List<String> account = new ArrayList<>();
		List<String> accountInDb = null;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("id : ");
		account.add(scanner.next());
		System.out.print("password : ");
		account.add(scanner.next());
		
		clientService service = new clientService();
		accountInDb = service.signIn();
		
		if (account.get(0).equals(accountInDb.get(0)) && account.get(1).equals(accountInDb.get(1))) {
			System.out.println("로그인 되었습니다. 멋진 공간을 이용하시길 바랍니다.");
			return isCreated;
		}
			
		System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도 해주시길 바랍니다.");
		return !isCreated;
	}

	private static boolean signUp() throws Exception {

		boolean isCreated = true;
		List<String> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.print("id : ");
		list.add(scanner.next());
		System.out.print("password : ");
		list.add(scanner.next());
		System.out.print("phone : ");
		list.add(scanner.next());

		clientService service = new clientService();
		isCreated = service.signUp(list);

		if (isCreated) {
			System.out.println("회원가입을 축하드립니다.");
			System.out.println("로그인 되었습니다.");
		}
		else {
			System.out.println("오류가 있으니 다시 회원가입 진행 부탁드립니다.");
			return !isCreated;
		}
		return isCreated;
	}
	
	private static int inspectPlaces() throws Exception{
		
		List<placeDTO> list = null;


		clientService service = new clientService();
		list = service.inspectPlaces();
		
		for(placeDTO dto : list) {
			System.out.println(dto.getPlaceNo()+"." + " " + dto.getPlaceNm());
		}
		
		System.out.println("총 : " + list.size() + " 명입니다.");
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
	
		boolean isSignIn = false;

		outer: while (true) {
			System.out.println("======================================");
			System.out.println("********* 회원제 게시판 프로그램 *********");
			System.out.println("======================================");

			System.out.println("[1. 로그인]");
			System.out.println("[2. 회원가입]");
			System.out.println("[0. 종료]");
			System.out.print("입력 => ");

			Scanner scan = new Scanner(System.in);
			int excuteNumber = scan.nextInt();

			while (!isSignIn) {
				if (excuteNumber == 1) {
					isSignIn = signIn();
					
				} else if (excuteNumber == 2) {
					isSignIn = signUp();
					
				} else if (excuteNumber == 0) {
					System.out.println("저희 프로그램을 이용해주셔서 감사합니다.");
					System.exit(0);
				}
				
			}
			
			while(true) {
				
				System.out.println("======================================");
				System.out.println("********* 회원제 게시판 프로그램 *********");
				System.out.println("======================================");
				
				System.out.println("[1. 예약 가능 지점]");
				System.out.println("[2. 예약 신청]");
				System.out.println("[3. 예약 조회]");
				System.out.println("[9. 로그아웃]");
				System.out.println("[0. 종료");
				System.out.print("입력 => ");
				
				
				int checkingNumber = scan.nextInt();
				
				outer_2: while (true) {
					if (checkingNumber == 1) {
						checkingNumber = inspectPlaces();
						break outer_2;
					} else if (checkingNumber == 2) {
						
						
					} else if (checkingNumber == 3) {
						
						
					} else if (checkingNumber == 9) {
						System.out.println("로그아웃 되었습니다.");
						break outer;
						
					} else if (checkingNumber == 0) {
						System.out.println("저희 프로그램을 이용해주셔서 감사합니다.");
						System.exit(0);
					}
				}
				
			}
			
			
			
		}
	}

}
