package pl.kowalecki.wordfrequency;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    @Value("uploads")
    public String uploadDir;


    public void uploadFile(MultipartFile file) {
        try {
            Path fileLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), fileLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileStorageException("Couldnt store file" + file.getOriginalFilename());
        }

    }

    public LinkedHashMap<String, Long> countWordFreq(String nameOfTheFile) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        TreeMap<String, Long> treeMap = new TreeMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("uploads/" + nameOfTheFile))) {
            br.lines()

                    .map(pattern::matcher)
                    .flatMap(Matcher::results)
                    .map(matchResult -> matchResult.group(0))
                    .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()))
                    .forEach(treeMap::put);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return sortMap(treeMap);
    }

    LinkedHashMap<String, Long> sortMap(TreeMap<String, Long> treeMap) {
        return treeMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

}
