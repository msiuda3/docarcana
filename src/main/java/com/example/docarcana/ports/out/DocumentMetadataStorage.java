package com.example.docarcana.ports.out;

import com.example.docarcana.model.DocumentMetaData;
import com.example.docarcana.model.Folder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DocumentMetadataStorage {
    List<DocumentMetaData> getAllDocuments();
    Optional<Folder> getRootFolder();
    Optional<Folder> getFolderByName();

    List<Folder> getChildrenFolders(Folder folder);
    Optional<DocumentMetaData> getDocumentById(UUID uuid);
    DocumentMetaData saveDocument(DocumentMetaData documentMetaData);

}
