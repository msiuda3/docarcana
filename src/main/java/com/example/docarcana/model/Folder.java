package com.example.docarcana.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Builder
@Data
public class Folder{
    private UUID id;
    private String name;
    private UUID parentId;

}
