package com.main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.dto.ClientDTO;
import com.dto.ManagerDTO;
import com.dto.PlaceDTO;
import com.dto.ReservationDTO;
import com.service.Service;
import com.service.ServiceImpl;

public class Main {
	
	public static void clientMain(ClientDTO dto) {

		Service service = new ServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("======================================");
			System.out.println("********* 회원제 게시판 프로그램 *********");
			System.out.println("======================================");

			System.out.println("[1. 예약 가능 지점]");
			System.out.println("[2. 예약 신청]");
			System.out.println("[3. 예약 조회]");
			System.out.println("[9. 로그아웃]");
			System.out.println("[0. 종료");
			System.out.print("입력 => ");

			int choice = sc.nextInt();

			if (choice == 1) {

				List<PlaceDTO> plist = null;

				try {
					plist = service.selectPlaceALL();
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (PlaceDTO pdto : plist) {
					System.out.println(pdto.getplace_no() + ". " + pdto.getplace_nm() + " " + pdto.getplace_ard());
				}

				System.out.println("총 : " + plist.size() + " 곳입니다.");

				System.out.println("지점을 입력하세요: ");

				int point = sc.nextInt();

				List<ReservationDTO> rlist = null;

				try {
					rlist = service.selectResByNo(point);
					System.out.println("[예약 불가 일정]");

					for (ReservationDTO rdto : rlist) {
						System.out.println("[ " + rdto.getRes_date() + " ]");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("선택을 잘못하였습니다.");
					continue;
				}

				System.out.println("예약일정을 입력하세요");

			} else if (choice == 2) {

				List<PlaceDTO> plist = null;

				try {
					plist = service.selectPlaceALL();
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (PlaceDTO pdto : plist) {
					System.out.println(pdto.getplace_no() + ". " + pdto.getplace_nm() + " " + pdto.getplace_ard());
				}

				System.out.println("지점을 입력하세요: ");

				int place_no = sc.nextInt();

				List<ReservationDTO> rlist = null;

				try {
					rlist = service.selectResByNo(place_no);
					System.out.println("[예약 불가 일정]");

					for (ReservationDTO rdto : rlist) {
						System.out.println("[ " + rdto.getRes_date() + " ]");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("선택을 잘못하였습니다.");
					continue;
				}

				System.out.println("예약일정을 입력하세요: ");
				String res_date = sc.next();

				try {
					rlist = service.selectResDate();
					for (ReservationDTO rdto : rlist) {
						if (res_date.equals(rdto.getRes_date())) {
							System.out.println("예약 불가능한 일정입니다.");
						} else {
							System.out.println("예약 가능한 일정입니다.");
							continue;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("예약 불가능");
				}

				try {
					service.insertResAll(new ReservationDTO(place_no, dto.getClient_no(), res_date));
					System.out.println("예약 되었습니다.");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (choice == 3) {

				List<ReservationDTO> rlist = service.selectResByCno(dto.getClient_no());
				for (ReservationDTO rdto : rlist) {
					System.out
							.println("예약번호 :" + rdto.getRes_no() + dto.getClient_nm() + "님의 예약정보" + rdto.getRes_date());

				}
				
				int resController = 0;
				switch(resController) {
				case 1:
					int cancelResNumber = 0;
					System.out.println("[ 예약 취소 ]\n");
					System.out.println("취소할 예약 번호 입력 >>");
					cancelResNumber = sc.nextInt();
					
					try {
						service.deleteResAll(cancelResNumber);
						System.out.println("취소 되었습니다.");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("취소 되지 않았습니다.");
					}
					
				case 2:
					HashMap map = new HashMap();
					System.out.println("[ 예약 변경 ]\n");
					System.out.println("변경하고 싶은 예약 번호 입력 >>");
					map.put("res_no", sc.nextInt());
					System.out.println("변경하고 싶은 일자 입력 >>");
					map.put("res_no", sc.next());
					
					map.put("client_no", dto.getClient_no());
					
					try {
						service.updateResDate(map);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("예약 변경 실패했습니다.");
					}
					
				case 3:
					continue;
				}
				
				
			} else if (choice == 9) {
				System.out.println("로그아웃 되었습니다.");
				break;

			} else if (choice == 0) {
				System.out.println("저희 프로그램을 이용해주셔서 감사합니다.");
				System.exit(0);
			}
		}
	}
	
public static void managerMain(ManagerDTO dto) {
		
		Service service = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[1. 관리중인 지점]");
		System.out.println("[2. 예약 관리]");
		System.out.println("[9. 로그아웃]");
		System.out.println("[0. 프로그램 종료]");
		System.out.print("입력 => ");
		
		int choice = sc.nextInt();
		
		if(choice == 1) {
			List<PlaceDTO> list = service.selectPlaceByMno(dto.getManager_no());
			for(PlaceDTO pdto : list) {
				System.out.println(pdto.getplace_no()+ "." + pdto.getplace_nm() + "-" + pdto.getplace_ard());
			}
			
		} else if (choice == 2) {
			System.out.println("******지점 관리 프로그램 *********");
			System.out.println("[1. 얘약 고객 조회]");
			System.out.println("[2. 예약 초기화]");
			System.out.println("[9. 로그아웃]");
			System.out.print("입력 => ");
			
			int num = sc.nextInt();
			if (num == 1) {
				System.out.println("일정 [고객명]");
				
				
			} else if(num == 2) {
				
			}
			
		} else if (choice == 9) {
			return;
		} else if (choice == 0) {
			System.out.println("BYE BYE");
			System.exit(choice);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Service service = new ServiceImpl();
		int choice = 0;

		while (true) {
			System.out.println("======================================");
			System.out.println("********* 회원제 게시판 프로그램 *********");
			System.out.println("======================================");

			System.out.println("[1. 로그인]");
			System.out.println("[2. 회원가입]");
			System.out.println("[0. 종료]");
			System.out.print("입력 => ");

			choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("1. client");
				System.out.println("2. manager");
				System.out.print("입력 => ");
				int signInAuth = sc.nextInt();

				switch (signInAuth) {
				case 1:
					ClientDTO cdto = new ClientDTO();
					HashMap<String, String> ClientMap = new HashMap<>();
					System.out.print("id : ");
					ClientMap.put("client_id", sc.next());
					System.out.print("password : ");
					ClientMap.put("client_pw", sc.next());

					cdto = service.clientSignIn(ClientMap);
					if (cdto == null) {
						System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도 해주시길 바랍니다.");
						break;
					}

					System.out.println("로그인 되었습니다. 멋진 공간을 이용해보세요");
					
					clientMain(cdto);
					break;

				case 2:
					ManagerDTO mdto = new ManagerDTO();
					HashMap<String, String> ManagerMap = new HashMap<>();
					System.out.print("id : ");
					ManagerMap.put("manager_id", sc.next());
					System.out.print("password : ");
					ManagerMap.put("manager_id", sc.next());

					
					mdto = service.managerSignIn(ManagerMap);
					if (mdto == null) {
						System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도 해주시길 바랍니다.");
						break;
					}

					System.out.println("로그인 되었습니다. 멋진 공간을 이용하시길 바랍니다.");

					managerMain(mdto);
					break;
				}

			} else if (choice == 2) {
				System.out.println("1. client");
				System.out.println("2. manager");
				System.out.print("입력 => ");
				int signUpAuth = sc.nextInt();

				switch (signUpAuth) {
				case 1:
					ClientDTO dto = new ClientDTO();
					HashMap<String, String> ClientMap = new HashMap<>();
					System.out.print("id : ");
					ClientMap.put("client_id", sc.next());
					System.out.print("password : ");
					ClientMap.put("client_pw", sc.next());
					System.out.print("name : ");
					ClientMap.put("client_nm", sc.next());
					System.out.print("phone : ");
					ClientMap.put("phone", sc.next());

					try {
						service.clientSignUp(ClientMap);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("다시 시도 해주시길 바랍니다.");
						break;
					}

					System.out.println("회원가입 되었습니다. 로그인 후 이용바랍니다.");

					break;

				case 2:
					ManagerDTO dto2 = new ManagerDTO();
					HashMap<String, String> managerMap = new HashMap<>();
					System.out.print("id : ");
					managerMap.put("manager_id", sc.next());
					System.out.print("password : ");
					managerMap.put("manager_pw", sc.next());
					System.out.print("phone : ");
					managerMap.put("phone", sc.next());

					try {
						service.clientSignUp(managerMap);
					} catch (Exception e) {
						System.out.println("다시 시도 해주시길 바랍니다.");
						break;
					}

					System.out.println("회원가입 되었습니다. 로그인 후 이용바랍니다.");

					break;
				}

			} else if (choice == 0) {
				System.out.println("BYE BYE");
				System.exit(choice);
			}
		}

	}

}
