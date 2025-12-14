package com.example.docarcana.ports.out;

import com.example.docarcana.model.FileBlob;

import java.nio.ByteBuffer;
import java.util.UUID;

public interface BlobStorage {
    FileBlob getBlobById(UUID uuid);
    FileBlob uploadBlob(ByteBuffer binaryData);
}
