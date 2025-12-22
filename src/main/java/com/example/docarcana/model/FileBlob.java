package com.example.docarcana.model;

import lombok.Builder;
import lombok.Data;

import java.nio.ByteBuffer;
import java.util.UUID;

@Builder
@Data
public class FileBlob {
    private UUID uuid;
    private ByteBuffer binaryData;
    private String fileFormat;
}
