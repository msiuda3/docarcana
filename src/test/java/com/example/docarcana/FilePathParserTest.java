package com.example.docarcana;


import com.example.docarcana.service.FilePathParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathParserTest {

    private FilePathParser filePathParser;

    @Test
    public void shouldParsePathCorrectly(){
        this.filePathParser = new FilePathParser();
        List<String> expected = new ArrayList<>();
        expected.add("invoices");
        expected.add("january");
        String input = "/invoices/january";

        assertEquals(expected, filePathParser.parsePath(input));
    }


}
