package com.example.docarcana.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {
        private DocumentMetaData documentMetaData;
        private FileBlob fileBlob;
}
