package com.example.pastebin.DTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {
    String id;
    String messageString;
}
