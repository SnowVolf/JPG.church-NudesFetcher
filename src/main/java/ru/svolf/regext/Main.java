package ru.svolf.regext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Regexp for JPG Crunch
    // https?:\/\/(www\.)?simp\d{1,50}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&\/\/=]*)
    public static void main(String[] args) {
        System.out.println("JPG.church nudes fetcher");
        System.out.println("This tool parses all strings in web page that matches regular expression");
        System.out.println("For more info check: https://github.com/SnowVolf/regex-extractor");
        System.out.println("Please enter full path to source file (e.g. C:\\User\\test.html):");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String filePath = in.readLine();
            System.out.println("Please Enter regexp");
            String regexp = in.readLine();
            System.out.println("File: " + filePath + "\nRegex: " + regexp);
            AtomicInteger total = new AtomicInteger();
            Pattern source = Pattern.compile(regexp);
            Files.lines(new File(filePath).toPath(), StandardCharsets.UTF_8).forEach(s -> {
                Matcher m = source.matcher(s);
                while (m.find()) {
                    // Urls with ".th" suffix are small gallery thumbnails
                    // Urls with ".md" suffix are preview thumbnails (on the detailed view page)
                    // To get full-sized images we need to delete that suffix
                    if (m.group().contains(".md.")){
                        System.out.println(m.group().replace(".md", ""));
                        total.getAndIncrement();
                    }
                }
            });
            System.out.println("Total fetched nudes: " + total);
            System.out.println("Finished. ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}