//package com.cat.controller;
//
//import com.yd.apk.exception.WebException;
//import com.yd.apk.util.FileUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.nio.channels.Channels;
//import java.nio.channels.FileChannel;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Optional;
//
//import static com.yd.apk.constant.Config.DIR;
//import static com.yd.apk.constant.Config.SUFFIX;
//import static java.nio.charset.StandardCharsets.UTF_8;
//import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
//import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
//
//@RestController
//@Slf4j
//public class DownloadController {
//
//    private static final WebException FILE_NOT_FOUND_EXCEPTION = WebException.from(HttpStatus.NOT_FOUND.value(), "文件不存在");
//
//    @GetMapping("/download/{type}")
//    public void download(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        logger.debug("请求下载 {} 的最新版本", type);
//        Path path = Paths.get(DIR, type).normalize();
//
//        if (!Files.exists(path)) {
//            throw FILE_NOT_FOUND_EXCEPTION;
//        }
//
//        Path target = FileUtils.getNewestFile(path).orElseThrow(() -> FILE_NOT_FOUND_EXCEPTION);
//        logger.info("{} 的最新版本是 {}", type, target);
//
//        this.transfer(target, request, response);
//    }
//
//    @GetMapping("/download/{type}/{version:.+}")
//    public void download(@PathVariable("type") String type, @PathVariable(value = "version") String version, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Path target = Paths.get(DIR, type, version + SUFFIX).normalize();
//        logger.debug("请求下载 {}", target);
//
//        if (!Files.exists(target)) {
//            logger.error("文件 {} 不存在", target);
//
//            throw FILE_NOT_FOUND_EXCEPTION;
//        }
//
//        this.transfer(target, request, response);
//    }
//
//    private void transfer(Path path, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        File file = path.toFile();//TODO
//
//        long length = Files.size(path);
//        response.setContentType(Optional.ofNullable(request.getServletContext().getMimeType(file.getCanonicalPath())).orElse(APPLICATION_OCTET_STREAM_VALUE));
//        response.setContentLengthLong(length);
//
//        response.setHeader(CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", new String(file.getName().getBytes(UTF_8), UTF_8)));
//
//        FileChannel.open(path).transferTo(0, length, Channels.newChannel(response.getOutputStream()));
//    }
//}
