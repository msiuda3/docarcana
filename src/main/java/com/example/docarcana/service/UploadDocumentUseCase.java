package com.example.docarcana.service;

import com.example.docarcana.infrastructure.UploadDocumentCommand;

import java.util.UUID;

public interface UploadDocumentUseCase {
    UUID uploadDocument(UploadDocumentCommand uploadDocumentCommand);
}
