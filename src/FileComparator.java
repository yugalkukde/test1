import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileComparator {
    public static void main(String[] args) {
        String file1Path = "D:\\Anon\\linux\\d.txt";
        String file2Path = "D:\\Anon\\linux\\ext.txt";

        try {
            Set<String> file1Lines = readFileLines(file1Path);
            Set<String> file2Lines = readFileLines(file2Path);

            Set<String> commonLines = new HashSet<>(file1Lines);
            commonLines.retainAll(file2Lines);

            System.out.println("Common lines in both files:");
            for (String line : commonLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

    private static Set<String> readFileLines(String filePath) throws IOException {
        Set<String> lines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
