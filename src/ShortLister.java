import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();

            Display(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void Display(java.io.File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Filter shortWordFilter = new ShortWordFilter();
            Object[] wordsArray = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> word.matches("[a-zA-Z]+"))
                    .toArray(String[]::new);
            Object[] shortWords = Main.collectAll(wordsArray, shortWordFilter);

            System.out.println("Short Words from the File:");
            for (Object word : shortWords) {
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
