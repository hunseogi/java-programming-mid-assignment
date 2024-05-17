import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chs20211561_mid2 {
  public static void main(String[] args) {
    RockPaperScissors game1 = new RockPaperScissors();
    ChamChamCham game2 = new ChamChamCham();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      // ���������� ���� ���� => ��� ȹ��
      final int result1 = game1.start(scanner);

      // ���������� ���� ��� => �����
      if (result1 == 0)
        continue;

      // �������������� ����� ���� ��� => ������ ������ ���� �������μ� ���� ������ ������ ������ ���� => ��� ȹ��
      // 
      final int result2 = game2.start(scanner);

      // ������������ �������� ���ڰ� ��ġ�ϴ� ���:
      if (result1 == result2) {
        switch (result1) {
          case 1:
            System.out.println("������!! ��ǻ���� ���� �̰��! �� ���� �� ��밡 �ȵǴ±��� (��ǻ�� ���� ��!)");
            scanner.close();
            return;
          case -1:
            System.out.println("ĩ.. �ʰ� �� �̰ܹ��ȱ� �������� ���ϴ� ������� ĩ..! (����� ���� ��!)");
            scanner.close();
            return;
        }
      } else {
        // ������������ �������� ���ڰ� ����ġ�ϴ� ���:
        System.out.println("ĩ ���ڰ� ������ �ʾұ�.. �ٽ� ������! (�ٽ� ������ �����մϴ�)");
      }
    }
  }
}

class RockPaperScissors {
  static ArrayList<String> evenMessages = new ArrayList<>(Arrays.asList("ĩ..����..!!", "�� �ϴ±�...����!", "��屺...!"));
  static ArrayList<String> ComputerWinMessages = new ArrayList<>(
      Arrays.asList("������! �� �� ��밡 �ȉդ� ���� �̰��!!", "��..�� �� ��밡 �ȵǴ°ž� ������!.", "���� �̰�� ��������!! �Ʒ���."));
  static ArrayList<String> PlayerWinMessages = new ArrayList<>(
      Arrays.asList("ĩ.. ���ϴ� �װ� �̰��!!!", "����! �̱� �� �־��µ�.. �װ� �̰��!!", "ĩ.. ������ �� �� ���� �װ� �̰��!!"));

  /**
   * ���������� ������ �����մϴ�
   * 
   * @returns �� ����� ��ȯ�մϴ� (����ڰ� �̱�� -1, ���� 0, ���� 1�� ��ȯ�մϴ�)
   */
  public int start(Scanner scanner) {
    while (true) {
      // ����ڿ��� �Է¹ޱ�
      System.out.print("�ȳ׸� ����..! ����, ����, ��...!!!: ");
      String userInput = scanner.nextLine();

      // ����� �Է� ��ȯ �� ��ǻ�� �Է� ����
      int userChoice = RockPaperScissors.toInt(userInput);
      int computerChoice = RockPaperScissors.randomChoice();

      if (userChoice == -1) {
        System.out.println("�ٺ��� �װ� �߸� �����ݾ�. �ٽ�!");
        continue;
      }

      // ���� ��� ����:
      // �Է� ������ userChoice�� ��, computerChoice�� �ڿ� �ֱ� ������ ������� -1�̸� ����� ��, 0�̸� ���,
      // 
      //
      // �̸�
      // ��ǻ�� ����.
      // ��, 2(�߸��� �Է�)�� ������ �ٽ� �����ؾ� ��
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

  /** ������ �������� �����ϴ� �Լ� */
  public static int randomChoice() {
    return (int) (Math.random() * 3);
  }

  public void printRandomMessage(ArrayList<String> messages) {
    /** �޽��� �迭 �� ������ �ε��� ���� */
    final int randomNumber = (int) Math.random() * messages.size();
    System.out.println(messages.get(randomNumber));
  }

  /**
   * ���� �� �Լ�
   * 
   * ������� ���� ������.
   * 
   * - -1: A�� �̱�
   * - 0: ���
   * - 1: B�� �̱�
   * - 2: �� �� ���� (��ȯ������ ������ int�� ��ȯ�ؾ� �ϴµ�, 0�� ���ļ� 2 �����, ���� ��� ����� ���
   * 
   * 
   * 
   * 
   * 
   * @param playerA �÷��̾� A�� ����
   * @param playerB �÷��̾� B�� ����
   */
  public static int evaluate(int playerA, int playerB) {
    // ���
    if (playerA == playerB)
      return 0;

    // �÷��̾� A�� �̱�
    if ((playerB + 1) % 3 == playerA)
      return -1;
    // �÷��̾� B�� �̱�
    if ((playerA + 1) % 3 == playerB)
      return 1;

    return 2;
  }

  /**
   * ## ���������� ������ ��ȯ �Լ� (���ڿ� -> ����)
   * 
   * - ����, ��� 0
   * - ����, ���� 1
   * - ��, ���� 2�� ��ȯ�մϴ�
   * - ��ȿ���� ���� ���� �Է��ϸ� -1�� ��ȯ�մϴ�
   * 
   * @param choice
   * @return
   */
  public static int toInt(String choice) {
    switch (choice) {
      case "����":
      case "��":
        return 0;
      case "����":
      case "��":
        return 1;
      case "��":
      case "��":
        return 2;
      default:
        return -1;
    }
  }

  /**
   * ## ���������� ������ ��ȯ �Լ� (���� -> ���ڿ�)
   * 
   * - 0�� "����"
   * - 1�� "����"
   * - 2�� "��"�� ��ȯ�մϴ�
   * - ��ȿ���� ���� ���� �Է��ϸ� ""(�� ���ڿ�)�� ��ȯ�մϴ�.
   * 
   * @param choice
   * @return
   */
  public static String toString(int choice) {
    if (choice == 0)
      return "����";
    if (choice == 1)
      return "����";
    if (choice == 2)
      return "��";
    return "";
  }
}

// 1. �������� ������ ���ʸ� ����
class ChamChamCham {
  /**
   * ������ ������ �����մϴ�
   * 
   * @returns �� ����� ��ȯ�մϴ� (����ڰ� �̱�� -1, ���� 0, ���� 1�� ��ȯ�մϴ�)
   */
  public int start(Scanner scanner) {
    while (true) {
      System.out.printf("������! (����, ������): ");
      String userInput = scanner.nextLine();

      int userChoice = ChamChamCham.toInt(userInput);
      int computerChoice = ChamChamCham.randomChoice();

      if (userChoice == -1) {
        System.out.println("�ٺ��� �װ� �߸� �����ݾ�. �ٽ�!");
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
   * ���� �� �Լ�
   * 
   * playerA�� ���������� �����ϰ� ���մϴ�.
   * 
   * playerA, �����ڰ� �̱�� -1, �ݴ��� 1�� ��ȯ�մϴ�
   */
  static int evaluate(int playerA, int playerB) {
    if (playerA == playerB)
      return -1;
    else
      return 1;
  }

  static int toInt(String option) {
    switch (option) {
      case "����":
        return 0;
      case "������":
        return 1;
      default:
        return -1;
    }
  }

  static String toString(int option) {
    switch (option) {
      case 0:
        return "����";
      case 1:
        return "������";
      default:
        return "�� �� ����";
    }
  }
}
