package com.example.docarcana.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class FilePathParser {


    // /invoices/january
    public List<String> parsePath(String filePath){
        String[] result = filePath.split("/");
        return Arrays.stream(result, 1, result.length)
                .toList();
    }
}
