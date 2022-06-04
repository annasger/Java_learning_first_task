import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Main {
    public static String[] dictionaryWord = new String[1000]; //Словарь слов

    public static void main(String[] args) throws FileNotFoundException {
        int num = 0; //Номер случайного слова из словаря
        StringBuilder word; //загаданное слово
        StringBuilder mask = new StringBuilder();  //слово "маска"
        char c; //вводимая пользователем буква
        Scanner console = new Scanner(System.in); //Сканер для работы с консолью

        DictionaryFilling();//Наполнение словаря словами
        //Выбираем из словаря случайное слово
        num = (int) (Math.random() * 1001);
        word = new StringBuilder(dictionaryWord[num]);

        System.out.println("Привет");
        //System.out.println(word);

        for (int i = 0; i < word.length(); i++) {
            mask.append('_');  //собираем маску
        }

        System.out.println("Мы загадали слово из " + mask.length() + "  букв!!!");


        while (word.compareTo(mask) != 0) //Пока слово и маска не одинаковые
        {
            System.out.println("Назовите букву:");
            c = console.next().charAt(0);  //Считываем букву из консоли
            //Ищем в загаданном слове букву и если таая есть, производим замену в маске:
            mask = new StringBuilder(SearhReplacechar(word, mask, c));
        }
        System.out.println("Ура, вы отгадали слово!");
    }


    /*Метод поиска буквы в слове и замены в маске соответствующего смвола буквой*/
    public static StringBuilder SearhReplacechar(StringBuilder word, StringBuilder mask, char c) {

        System.out.println("Вы назвали букву : " + c);
        int position = -1;
        do {
            position = word.indexOf(String.valueOf(c), position + 1);
            if (position >= 0) {
                mask.replace(position, position + 1, String.valueOf(c));
            }
        }
        while (position >= 0);

        System.out.println("Отгадываемое слово: " + mask);
        return mask;
    }


    /*Наполнение словаря словами*/
    public static void DictionaryFilling() throws FileNotFoundException {
        File file = new File("./src/dictionary.txt"); //Файл со словами
        int i = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) { //До тех пор пока есть слова, добавляем их в массив
                dictionaryWord[i] = sc.nextLine();
                // System.out.println(dictionaryWord[i]);
                i++;
            }
        }
    }


}