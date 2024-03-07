import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDeleter {
    public static void main(String[] args) {
        String filesToDeleteFilePath = "D:\\Anon\\linux\\del.txt";
        String locationToDeleteFiles = "E:\\p\\ind\\video";

        try {
            List<String> fileNamesToDelete = readFilesToDelete(filesToDeleteFilePath);
            deleteFiles(locationToDeleteFiles, fileNamesToDelete);
            System.out.println("Files deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error reading files or deleting: " + e.getMessage());
        }
    }

    private static List<String> readFilesToDelete(String filePath) throws IOException {
        List<String> fileNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileNames.add(line);
            }
        }
        return fileNames;
    }

    private static void deleteFiles(String location, List<String> fileNamesToDelete) {
        File directory = new File(location);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Location is not a valid directory: " + location);
            return;
        }

        for (String fileName : fileNamesToDelete) {
            File fileToDelete = new File(directory, fileName);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    System.out.println("Deleted: " + fileToDelete.getAbsolutePath());
                } else {
                    System.err.println("Failed to delete: " + fileToDelete.getAbsolutePath());
                }
            } else {
                System.err.println("File not found: " + fileToDelete.getAbsolutePath());
            }
        }
    }
}
