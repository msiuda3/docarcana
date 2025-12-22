package com.example.docarcana.adapters;

import com.example.docarcana.model.FileBlob;
import com.example.docarcana.ports.out.BlobStorage;

import java.nio.ByteBuffer;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BlobStorageTestAdapter implements BlobStorage {
    private Map<UUID, FileBlob> blobs;

    public BlobStorageTestAdapter(){
       this.blobs = new HashMap<>();
    }

    @Override
    public FileBlob getBlobById(UUID uuid) {
        return blobs.get(uuid);
    }

    @Override
    public FileBlob uploadBlob(ByteBuffer binaryData) {
        FileBlob blob = FileBlob.builder()
                .uuid(UUID.randomUUID())
                .binaryData(binaryData)
                .build();
        blobs.put(blob.getUuid(),blob);
        return blob;
    }
}
