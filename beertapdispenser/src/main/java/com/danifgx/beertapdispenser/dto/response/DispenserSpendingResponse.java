package com.danifgx.beertapdispenser.dao.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DispenserSpendingResponse {
    private String openedAt; // Use LocalDateTime type
    private String closedAt; // Use LocalDateTime type or null
    private double flowVolume;
    private double totalSpent;

}