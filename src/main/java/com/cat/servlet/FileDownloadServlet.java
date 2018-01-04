package com.cat.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

/**
 * tomcat dir:conf/web.xml 定义了 MIME types
 */
public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String filePath = "E:/down/aio12.zip";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);

        // obtains ServletContext
        ServletContext context = getServletContext();

        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }

    private void transfer(Path path, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = path.toFile();//TODO

        long length = Files.size(path);
        response.setContentType(Optional.ofNullable(request.getServletContext().getMimeType(file.getCanonicalPath())).orElse(APPLICATION_OCTET_STREAM_VALUE));
        response.setContentLengthLong(length);

        response.setHeader(CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", new String(file.getName().getBytes(UTF_8), UTF_8)));

        FileChannel.open(path).transferTo(0, length, Channels.newChannel(response.getOutputStream()));
    }

}
