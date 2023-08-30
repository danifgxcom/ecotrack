package org.example.merkle;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    List<String> transactions = new ArrayList<>();
    String root;

    public MerkleTree(List<String> transactions) {
        this.transactions = transactions;
        root = computeMerkleRoot(transactions);
    }

    private String computeMerkleRoot(List<String> transactions) {
        if (transactions.isEmpty()) {
            return "";
        }
        if (transactions.size() == 1) {
            return transactions.get(0);
        }

        List<String> updatedTxs = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i += 2) {
            if (i + 1 < transactions.size()) {
                updatedTxs.add(hash(transactions.get(i) + transactions.get(i + 1)));
            } else {
                updatedTxs.add(transactions.get(i));
            }
        }

        return computeMerkleRoot(updatedTxs);
    }

    private String hash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        List<String> txs = List.of("a", "b", "c", "d");
        MerkleTree tree = new MerkleTree(txs);
        System.out.println("Root: " + tree.getRoot());
    }
}
