package com.example.docarcana.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class DocumentMetaData{
        private UUID uuid;
        private UUID parentId;
        private String name;
        private String type;
        private Map<String, String> properties;
        private UUID fileBlobId;
}
