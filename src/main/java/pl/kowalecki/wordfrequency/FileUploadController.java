package pl.kowalecki.wordfrequency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.annotation.MultipartConfig;
import java.util.TreeMap;


@Controller
public class FileUploadController {


    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/uploadFile")

    public ResponseEntity<TreeMap> uploadNewFile(@RequestParam("file") MultipartFile file){
        try{
            fileUploadService.uploadFile(file);
            return new ResponseEntity<>(fileUploadService.countWordFreq(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
