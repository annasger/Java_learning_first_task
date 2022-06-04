import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Main {
    public static String[] dictionaryWord = new String[1000]; //������� ����

    public static void main(String[] args) throws FileNotFoundException {
        int num = 0; //����� ���������� ����� �� �������
        StringBuilder word; //���������� �����
        StringBuilder mask = new StringBuilder();  //����� "�����"
        char c; //�������� ������������� �����
        Scanner console = new Scanner(System.in); //������ ��� ������ � ��������

        DictionaryFilling();//���������� ������� �������
        //�������� �� ������� ��������� �����
        num = (int) (Math.random() * 1001);
        word = new StringBuilder(dictionaryWord[num]);

        System.out.println("������");
        //System.out.println(word);

        for (int i = 0; i < word.length(); i++) {
            mask.append('_');  //�������� �����
        }

        System.out.println("�� �������� ����� �� " + mask.length() + "  ����!!!");


        while (word.compareTo(mask) != 0) //���� ����� � ����� �� ����������
        {
            System.out.println("�������� �����:");
            c = console.next().charAt(0);  //��������� ����� �� �������
            //���� � ���������� ����� ����� � ���� ���� ����, ���������� ������ � �����:
            mask = new StringBuilder(SearhReplacechar(word, mask, c));
        }
        System.out.println("���, �� �������� �����!");
    }


    /*����� ������ ����� � ����� � ������ � ����� ���������������� ������ ������*/
    public static StringBuilder SearhReplacechar(StringBuilder word, StringBuilder mask, char c) {

        System.out.println("�� ������� ����� : " + c);
        int position = -1;
        do {
            position = word.indexOf(String.valueOf(c), position + 1);
            if (position >= 0) {
                mask.replace(position, position + 1, String.valueOf(c));
            }
        }
        while (position >= 0);

        System.out.println("������������ �����: " + mask);
        return mask;
    }


    /*���������� ������� �������*/
    public static void DictionaryFilling() throws FileNotFoundException {
        File file = new File("./src/dictionary.txt"); //���� �� �������
        int i = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) { //�� ��� ��� ���� ���� �����, ��������� �� � ������
                dictionaryWord[i] = sc.nextLine();
                // System.out.println(dictionaryWord[i]);
                i++;
            }
        }
    }


}