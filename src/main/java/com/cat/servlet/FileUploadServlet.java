package com.cat.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
@WebServlet("/upload")
@MultipartConfig//识别multipart/form-data
@Slf4j
public class FileUploadServlet extends HttpServlet {

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("desc");
        logger.info("desc:{}", desc);

        Part part = req.getPart("file");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        logger.info("name:{}", part.getName());
        logger.info("submit name:{}", part.getSubmittedFileName());

        //TODO:        part.write("19851124.dat");//不推荐?
        //ServletInputStream content = req.getInputStream();// ERROR

        InputStream content = part.getInputStream();

        logger.info("available size:{}", content.available());

        String dir = "e:/down/upload";
        Files.copy(content, Paths.get(dir, fileName), StandardCopyOption.REPLACE_EXISTING);

        logger.info("upload success");

        //
//        List<Part> fileParts = req.getParts().stream().filter(part -> "file".equals(part.getName())).collect(toList()); // Retrieves <input type="file" name="file" multiple="true">
//
//        for (Part filePart : fileParts) {
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//            InputStream fileContent = filePart.getInputStream();
//            // ... (do your job here)
//        }
    }

}
