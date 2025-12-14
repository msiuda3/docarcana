package com.example.docarcana.infrastructure;

import java.nio.ByteBuffer;

public record UploadDocumentCommand(
        String name,
        String filePath,
        String type,
        ByteBuffer binaryData

) {
}
