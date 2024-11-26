package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        try {
            // Đường dẫn tới file
            String filename = "C:\\Users\\hinhn\\.vscode\\LTHDT_Java\\Lab02_03_04_05_20225842_NguyenTrongHinh\\OtherProject\\src\\hust\\soict\\hedspi\\garbage\\file.exe";
            
            // Đọc file thành mảng byte
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            
            long startTime = System.currentTimeMillis();

            // Xử lý dữ liệu từ file
            StringBuilder outputString = new StringBuilder();
            for (byte b : inputBytes) {
                outputString.append((char) b);
            }

            long endTime = System.currentTimeMillis();

            // In thời gian xử lý
            System.out.println("Processing time: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            // Thông báo lỗi đọc file
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            // Thông báo các lỗi khác
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
