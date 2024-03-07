import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSizeCalculator {
    public static void main(String[] args) {
        String filesToDeleteFilePath = "D:\\Anon\\linux\\del.txt";;
        String locationToDeleteFiles = "E:\\p\\ind\\video";

        try {
            List<String> fileNamesToDelete = readFilesToDelete(filesToDeleteFilePath);
            long totalSize = getTotalSize(locationToDeleteFiles, fileNamesToDelete);
            System.out.println("Total size of files to be deleted: " + formatSize(totalSize));
        } catch (IOException e) {
            System.err.println("Error reading files or calculating size: " + e.getMessage());
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

    private static long getTotalSize(String location, List<String> fileNamesToDelete) {
        File directory = new File(location);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Location is not a valid directory: " + location);
            return 0;
        }

        long totalSize = 0;
        for (String fileName : fileNamesToDelete) {
            File file = new File(directory, fileName);
            if (file.exists()) {
                totalSize += file.length();
            } else {
                System.err.println("File not found: " + file.getAbsolutePath());
            }
        }
        return totalSize;
    }

    private static String formatSize(long size) {
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        double sizeInBytes = size;

        while (sizeInBytes >= 1024 && unitIndex < units.length - 1) {
            sizeInBytes /= 1024;
            unitIndex++;
        }

        return String.format("%.2f %s", sizeInBytes, units[unitIndex]);
    }
}
