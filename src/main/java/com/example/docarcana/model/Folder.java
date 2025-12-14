package com.example.docarcana.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Folder{
    private UUID id;
    private String name;
    private UUID parentId;

}
