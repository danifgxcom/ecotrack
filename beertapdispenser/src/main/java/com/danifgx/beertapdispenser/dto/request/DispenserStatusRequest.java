package com.danifgx.beertapdispenser.dao.request;

import java.time.LocalDateTime;

public class DispenserStatusRequest {
    private String status; // "open" or "close"
    private LocalDateTime updatedAt;
    // Getters and setters
}