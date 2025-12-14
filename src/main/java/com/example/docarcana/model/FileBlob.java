package com.example.docarcana.model;

import lombok.Data;

import java.nio.ByteBuffer;
import java.util.UUID;

@Data
public class FileBlob {
    private UUID uuid;
    private ByteBuffer binaryData;
    private String fileFormat;
}
