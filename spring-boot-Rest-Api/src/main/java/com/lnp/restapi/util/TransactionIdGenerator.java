package com.lnp.restapi.util;

import java.util.UUID;

public class TransactionIdGenerator {

    // Generate a unique transaction ID using UUID and phone number
    public static String generateTransactionId(String phoneNumber) {
        return phoneNumber + "-" + UUID.randomUUID().toString();
    }
}

