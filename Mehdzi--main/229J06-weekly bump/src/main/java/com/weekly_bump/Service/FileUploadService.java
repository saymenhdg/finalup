package com.weekly_bump.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${upload.path:/default/upload/path}")  // Default path if not provided
    private String uploadPath;

    // Method to upload files to the specified path
    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        File destination = new File(uploadPath + File.separator + fileName);

        // Ensure directories exist
        destination.getParentFile().mkdirs();
        file.transferTo(destination);  // Save the file to the destination

        return fileName;  // Return the filename for storing in DB
    }
}
