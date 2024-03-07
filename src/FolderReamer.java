import java.io.File;

public class FolderReamer {
    public static void main(String[] args) {
        String targetDirectory = "D:\\Anon\\New folder\\ind\\sorted";

        File folder = new File(targetDirectory);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String folderName = file.getName();
                    String newFolderName = folderName.substring(0, folderName.length() - 1);

                    File newFolder = new File(targetDirectory, newFolderName);
                    boolean renamed = file.renameTo(newFolder);

                    if (renamed) {
                        System.out.println("Renamed folder: " + folderName + " to " + newFolderName);
                    } else {
                        System.out.println("Failed to rename folder: " + folderName);
                    }
                }
            }
        }
    }
}