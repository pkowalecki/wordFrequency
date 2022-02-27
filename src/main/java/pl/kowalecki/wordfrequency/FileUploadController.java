package pl.kowalecki.wordfrequency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FileUploadController {


    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadNewFile(@RequestParam("file") MultipartFile file){
        fileUploadService.uploadFile(file);

        return new ResponseEntity<>(fileUploadService.uploadDir, HttpStatus.OK);

    }
}
