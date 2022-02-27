package pl.kowalecki.wordfrequency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootApplication
public class WordFrequencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordFrequencyApplication.class, args);



    }

}
