import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chs20211561_mid2 {
  public static void main(String[] args) {
    RockPaperScissors game1 = new RockPaperScissors();
    ChamChamCham game2 = new ChamChamCham();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      // 가위바위보 게임 진행 => 결과 획득
      final int result1 = game1.start(scanner);

      // 가위바위보 비기는 경우 => 재실행
      if (result1 == 0)
        continue;

      // 가위바위보에서 결과가 나온 경우 => 별도로 조건을 두지 않음으로서 다음 게임인 참참참 게임을 진행 => 결과 획득
      // 
      final int result2 = game2.start(scanner);

      // 가위바위보와 참참참의 승자가 일치하는 경우:
      if (result1 == result2) {
        switch (result1) {
          case 1:
            System.out.println("하하하!! 컴퓨터인 내가 이겼다! 넌 역시 내 상대가 안되는군ㅋ (컴퓨터 최종 승!)");
            scanner.close();
            return;
          case -1:
            System.out.println("칫.. 너가 다 이겨버렸군 분하지만 축하는 해줘야지 칫..! (사용자 최종 승!)");
            scanner.close();
            return;
        }
      } else {
        // 가위바위보와 참참참의 승자가 불일치하는 경우:
        System.out.println("칫 승자가 나오질 않았군.. 다시 결투다! (다시 결투를 시작합니다)");
      }
    }
  }
}

class RockPaperScissors {
  static ArrayList<String> evenMessages = new ArrayList<>(Arrays.asList("칫..비겼다..!!", "좀 하는군...비겼다!", "비겼군...!"));
  static ArrayList<String> ComputerWinMessages = new ArrayList<>(
      Arrays.asList("하하하! 넌 내 상대가 안됔ㅋ 내가 이겼다!!", "훗..넌 내 상대가 안되는거야 하하하!.", "내가 이겼어 하하하하!! 아래야."));
  static ArrayList<String> PlayerWinMessages = new ArrayList<>(
      Arrays.asList("칫.. 분하다 네가 이겼어!!!", "젠장! 이길 수 있었는데.. 네가 이겼다!!", "칫.. 나보다 한 수 위군 네가 이겼다!!"));

  /**
   * 가위바위보 게임을 실행합니다
   * 
   * @returns 평가 결과를 반환합니다 (사용자가 이기면 -1, 비기면 0, 지면 1을 반환합니다)
   */
  public int start(Scanner scanner) {
    while (true) {
      // 사용자에게 입력받기
      System.out.print("안네면 진다..! 가위, 바위, 보...!!!: ");
      String userInput = scanner.nextLine();

      // 사용자 입력 변환 및 컴퓨터 입력 생성
      int userChoice = RockPaperScissors.toInt(userInput);
      int computerChoice = RockPaperScissors.randomChoice();

      if (userChoice == -1) {
        System.out.println("바보야 그건 잘못 낸거잖아. 다시!");
        continue;
      }

      // 게임 결과 저장:
      // 입력 변수로 userChoice가 앞, computerChoice가 뒤에 있기 때문에 결과값이 -1이면 사용자 승, 0이면 비김,
      // 
      //
      // 이면
      // 컴퓨터 승임.
      // 단, 2(잘못된 입력)가 나오면 다시 수행해야 함
      int result = RockPaperScissors.evaluate(userChoice, computerChoice);

      if (result == 0)
        this.printRandomMessage(evenMessages);
      else if (result == -1)
        this.printRandomMessage(PlayerWinMessages);
      else if (result == 1)
        this.printRandomMessage(ComputerWinMessages);

      return result;
    }

  }

  /** 랜덤한 선택지를 생성하는 함수 */
  public static int randomChoice() {
    return (int) (Math.random() * 3);
  }

  public void printRandomMessage(ArrayList<String> messages) {
    /** 메시지 배열 중 랜덤한 인덱스 선택 */
    final int randomNumber = (int) Math.random() * messages.size();
    System.out.println(messages.get(randomNumber));
  }

  /**
   * 승자 평가 함수
   * 
   * 결과값은 같이 가정함.
   * 
   * - -1: A가 이김
   * - 0: 비김
   * - 1: B가 이김
   * - 2: 알 수 없음 (반환값으로 무조건 int를 반환해야 하는데, 0은 겹쳐서 2 사용함, 예외 사례 생기면 사용
   * 
   * 
   * 
   * 
   * 
   * @param playerA 플레이어 A의 선택
   * @param playerB 플레이어 B의 선택
   */
  public static int evaluate(int playerA, int playerB) {
    // 비김
    if (playerA == playerB)
      return 0;

    // 플레이어 A가 이김
    if ((playerB + 1) % 3 == playerA)
      return -1;
    // 플레이어 B가 이김
    if ((playerA + 1) % 3 == playerB)
      return 1;

    return 2;
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

// 1. 선택지는 오른쪽 왼쪽만 가능
class ChamChamCham {
  /**
   * 참참참 게임을 실행합니다
   * 
   * @returns 평가 결과를 반환합니다 (사용자가 이기면 -1, 비기면 0, 지면 1을 반환합니다)
   */
  public int start(Scanner scanner) {
    while (true) {
      System.out.printf("참참참! (왼쪽, 오른쪽): ");
      String userInput = scanner.nextLine();

      int userChoice = ChamChamCham.toInt(userInput);
      int computerChoice = ChamChamCham.randomChoice();

      if (userChoice == -1) {
        System.out.println("바보야 그건 잘못 낸거잖아. 다시!");
        continue;
      }

      int result = ChamChamCham.evaluate(userChoice, computerChoice);

      return result;
    }
  }

  static int randomChoice() {
    return (int) Math.random() * 2;
  }

  /**
   * 승자 평가 함수
   * 
   * playerA가 공격자임을 가정하고 평가합니다.
   * 
   * playerA, 공격자가 이기면 -1, 반대라면 1을 반환합니다
   */
  static int evaluate(int playerA, int playerB) {
    if (playerA == playerB)
      return -1;
    else
      return 1;
  }

  static int toInt(String option) {
    switch (option) {
      case "왼쪽":
        return 0;
      case "오른쪽":
        return 1;
      default:
        return -1;
    }
  }

  static String toString(int option) {
    switch (option) {
      case 0:
        return "왼쪽";
      case 1:
        return "오른쪽";
      default:
        return "알 수 없음";
    }
  }
}
