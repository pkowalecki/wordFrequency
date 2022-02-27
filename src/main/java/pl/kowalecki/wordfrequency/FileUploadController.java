package pl.kowalecki.wordfrequency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;


@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/uploadFile")
    public ResponseEntity<LinkedHashMap> uploadNewFile(@RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.uploadFile(file);
            return new ResponseEntity<>(fileUploadService.countWordFreq(file.getOriginalFilename()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
