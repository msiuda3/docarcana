package com.example.docarcana.service;

import com.example.docarcana.infrastructure.UploadDocumentCommand;
import com.example.docarcana.model.DocumentMetaData;
import com.example.docarcana.model.FileBlob;
import com.example.docarcana.model.Folder;
import com.example.docarcana.ports.out.BlobStorage;
import com.example.docarcana.ports.out.DocumentMetadataStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
public class UploadDocumentService implements UploadDocumentUseCase {

    private final DocumentMetadataStorage documentMetadataStorage;
    private final BlobStorage blobStorage;

    private final FilePathParser filePathParser;

    @Override
    public UUID uploadDocument(UploadDocumentCommand uploadDocumentCommand) {
        log.info("uploadDocument Start()");
        List<String> folders = filePathParser.parsePath(uploadDocumentCommand.filePath());
        Folder parentFolder = documentMetadataStorage.getRootFolder().orElseThrow();
        for (int i = 0; i < folders.size(); i++){
            parentFolder = resolvePath(parentFolder, folders.get(i));
        }
        FileBlob fileBlob = blobStorage.uploadBlob(uploadDocumentCommand.binaryData());
        DocumentMetaData createdDocument = DocumentMetaData.builder()
                .name(uploadDocumentCommand.name())
                .type(uploadDocumentCommand.type())
                .properties(new HashMap<>())
                .parentId(parentFolder.getId())
                .fileBlobId(fileBlob.getUuid())
        .build();
        createdDocument = documentMetadataStorage.saveDocument(createdDocument);
        return createdDocument.getUuid();
    }


    private Folder resolvePath(Folder parentFolder, String folderName){
        List<Folder> folders = documentMetadataStorage.getChildrenFolders(parentFolder);

        Optional<Folder> folderOptional = folders.stream()
                .filter(f -> f.getName().equals(folderName))
                .findAny();

        return folderOptional.get(); // TODO handle invalid path
    }

}
