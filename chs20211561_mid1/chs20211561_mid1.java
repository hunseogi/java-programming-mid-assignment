import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chs20211561_mid1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // === �Է� ���� ===

    // ����� �Է� �ޱ�
    System.out.print("�ȳ׸� ����..! ����, ����, ��...!!!: ");

    String userInput = scanner.nextLine();

    /** ����� �Է� �޾Ƽ� ��ȯ */
    int userChoice = chs20211561_mid1.toInt(userInput);
    /** ��ǻ�� �Է� ���� (�����ϰ�) */
    int computerChoice = (int) (Math.random() * 3);

    // === ���� �м� ===

    ArrayList<String> EvenMessages = new ArrayList<>(Arrays.asList("ĩ..����..!!", "�� �ϴ±�...����!", "��屺...!s"));
    ArrayList<String> ComputerWinMessages = new ArrayList<>(
        Arrays.asList("������! �� �� ��밡 �ȉդ� ���� �̰��!!", "��..�� �� ��밡 �ȵǴ°ž� ������!.", "���� �̰�� ��������!! �� �� �Ʒ���."));
    ArrayList<String> PlayerWinMessages = new ArrayList<>(
        Arrays.asList("ĩ.. ���ϴ� �װ� �̰��!!!", "����! �̱� �� �־��µ�.. �װ� �̰��!!", "ĩ.. ������ �� �� ���� �װ� �̰��!!"));

    // ���
    if (userChoice == computerChoice)
      System.out.println(EvenMessages.get((int) Math.random() * EvenMessages.size()));
    // ��ǻ�Ͱ� �̱�
    else if ((userChoice + 1) % 3 == computerChoice)
      System.out.println(ComputerWinMessages.get((int) Math.random() * ComputerWinMessages.size()));
    // ����ڰ� �̱�
    else if ((computerChoice + 1) % 3 == userChoice)
      System.out.println(PlayerWinMessages.get((int) Math.random() * PlayerWinMessages.size()));
    // �� ��
    else
      System.out.println("�װ� ����, ����, ���� �ƴ��ݾ�!!.");

    // ��ĳ�� �ݱ�
    scanner.close();
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