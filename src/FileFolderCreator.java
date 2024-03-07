import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileFolderCreator {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Anon\\New folder\\ind";
        String targetDirectory = "D:\\Anon\\New folder\\ind\\sorted";

        File folder = new File(sourceDirectory);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String folderName = fileName.substring(0, fileName.length() - 5);

                    File targetFolder = new File(targetDirectory, folderName);
                    targetFolder.mkdirs();

                    Path sourcePath = file.toPath();
                    Path targetPath = new File(targetFolder, fileName).toPath();

                    try {
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Moved file: " + fileName);
                    } catch (IOException e) {
                        System.out.println("Failed to move file: " + fileName);
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}