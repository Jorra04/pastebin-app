package com.example.pastebin.controllers;

import com.example.pastebin.DTOs.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/")
public class pastecontroller {
    private static final HashMap<String, String> idTimestampMap = new HashMap<String, String>();

    @PostMapping("")
    public ResponseEntity<String> saveText(@RequestBody Message message) {
        addUUID(
                message.getId(),
                message.getMessageString()
        );

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> test(@PathVariable String id) {
        String message = idTimestampMap.get(id);
        return message == null ? ResponseEntity.badRequest().body("No message exists with this id.") :
                ResponseEntity.ok(message);
    }


    public synchronized void addUUID(String id, String content) {
        idTimestampMap.put(id, content);
        new Thread(() -> {
            try {
                Thread.sleep(5 * 60 * 1000);
                System.out.printf("Removing UUID: %s\n", id.toString());
                removeUUID(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void removeUUID(String id) {
        idTimestampMap.remove(id);
    }
}
