package nhn;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        HashMap <String, ArrayList<String>> wordMap = new HashMap<>();

        try {
            File file = new File("/Users/gimseohyeon/seo/nhn/words.txt");
            Scanner scanner = new Scanner(file);

            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",|\n|\t| ");
                for (String word : words) {
                    ArrayList<String> lines;
                    if (wordMap.containsKey(word)) {
                        lines = wordMap.get(word);
                    } else {
                        lines = new ArrayList<>();
                    }
                    lines.add(line);
                    wordMap.put(word, lines);
                }
                lineNumber++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 단어를 입력: ");
            String input = scanner.nextLine();
            if (input.equals("exit()")) {
                break;
            }

            if (wordMap.containsKey(input)) {
                for (String line : wordMap.get(input)) {
                    System.out.println(line);
                }
            } else {
                System.out.println(input + "을(를) 찾을 수 없습니다.");
            }
        }
        scanner.close();
    }
}
