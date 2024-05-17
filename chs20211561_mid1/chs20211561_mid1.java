import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chs20211561_mid1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // === 입력 로직 ===

    // 사용자 입력 받기
    System.out.print("안네면 진다..! 가위, 바위, 보...!!!: ");

    String userInput = scanner.nextLine();

    /** 사용자 입력 받아서 변환 */
    int userChoice = chs20211561_mid1.toInt(userInput);
    /** 컴퓨터 입력 생성 (랜덤하게) */
    int computerChoice = (int) (Math.random() * 3);

    // === 승패 분석 ===

    ArrayList<String> EvenMessages = new ArrayList<>(Arrays.asList("칫..비겼다..!!", "좀 하는군...비겼다!", "비겼군...!s"));
    ArrayList<String> ComputerWinMessages = new ArrayList<>(
        Arrays.asList("하하하! 넌 내 상대가 안됔ㅋ 내가 이겼다!!", "훗..넌 내 상대가 안되는거야 하하하!.", "내가 이겼어 하하하하!! 넌 내 아래야."));
    ArrayList<String> PlayerWinMessages = new ArrayList<>(
        Arrays.asList("칫.. 분하다 네가 이겼어!!!", "젠장! 이길 수 있었는데.. 네가 이겼다!!", "칫.. 나보다 한 수 위군 네가 이겼다!!"));

    // 비김
    if (userChoice == computerChoice)
      System.out.println(EvenMessages.get((int) Math.random() * EvenMessages.size()));
    // 컴퓨터가 이김
    else if ((userChoice + 1) % 3 == computerChoice)
      System.out.println(ComputerWinMessages.get((int) Math.random() * ComputerWinMessages.size()));
    // 사용자가 이김
    else if ((computerChoice + 1) % 3 == userChoice)
      System.out.println(PlayerWinMessages.get((int) Math.random() * PlayerWinMessages.size()));
    // 그 외
    else
      System.out.println("그건 가위, 바위, 보가 아니잖아!!.");

    // 스캐너 닫기
    scanner.close();
  }

  /**
   * ## 가위바위보 선택지 변환 함수 (문자열 -> 정수)
   * 
   * - 가위, 찌는 0
   * - 바위, 묵은 1
   * - 보, 빠는 2로 변환합니다
   * - 유효하지 않은 값을 입력하면 -1로 변환합니다
   * 
   * @param choice
   * @return
   */
  public static int toInt(String choice) {
    switch (choice) {
      case "가위":
      case "찌":
        return 0;
      case "바위":
      case "묵":
        return 1;
      case "보":
      case "빠":
        return 2;
      default:
        return -1;
    }
  }

  /**
   * ## 가위바위보 선택지 변환 함수 (정수 -> 문자열)
   * 
   * - 0은 "가위"
   * - 1은 "바위"
   * - 2는 "보"로 변환합니다
   * - 유효하지 않은 값을 입력하면 ""(빈 문자열)를 반환합니다.
   * 
   * @param choice
   * @return
   */
  public static String toString(int choice) {
    if (choice == 0)
      return "가위";
    if (choice == 1)
      return "바위";
    if (choice == 2)
      return "보";
    return "";
  }
}