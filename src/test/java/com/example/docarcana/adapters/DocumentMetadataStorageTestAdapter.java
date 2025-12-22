package com.example.docarcana.adapters;

import com.example.docarcana.model.DocumentMetaData;
import com.example.docarcana.model.Folder;
import com.example.docarcana.ports.out.DocumentMetadataStorage;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentMetadataStorageTestAdapter implements DocumentMetadataStorage {

    private Map<UUID, Folder> folders;
    private Folder rootFolder;
    private Map<UUID, DocumentMetaData> documents;

    public DocumentMetadataStorageTestAdapter(){
        this.rootFolder = Folder.builder()
                .id(UUID.randomUUID())
                .name("root")
                .parentId(null)
                .build();
        this.folders = new HashMap<>();
        this.folders.put(this.rootFolder.getId(), this.rootFolder);
        this.documents = new HashMap<>();
    }

    @Override
    public List<DocumentMetaData> getAllDocuments() {
        return documents.values().stream().toList();
    }

    @Override
    public Optional<Folder> getRootFolder() {
        return Optional.ofNullable(this.rootFolder);
    }

    @Override
    public Optional<Folder> getFolderByName(String name) {
        return folders.values().stream().filter(folder -> folder.getName().equals(name)).findAny();
    }

    @Override
    public List<Folder> getChildrenFolders(Folder folder) {
        return folders.values().stream().filter(f -> f.getParentId().equals(folder.getId())).collect(Collectors.toList());
    }

    @Override
    public List<DocumentMetaData> getAllDocumentsForFolder(Folder folder) {
        return documents.values().stream().filter(f -> f.getParentId().equals(folder.getId())).collect(Collectors.toList());
    }

    @Override
    public Optional<DocumentMetaData> getDocumentById(UUID uuid) {
        return Optional.ofNullable(documents.get(uuid));
    }

    @Override
    public DocumentMetaData saveDocument(DocumentMetaData documentMetaData) {
        if(documentMetaData.getUuid() == null){
            documentMetaData.setUuid(UUID.randomUUID());
        }
        documents.put(documentMetaData.getUuid(), documentMetaData);
        return documentMetaData;
    }
}
