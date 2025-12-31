package model;

public final class Transaction {
    public enum Type { BUY, SELL }

    private static int counter = 0; 

    private final int id;
    private final Type type;
    private final String assetname;
    private final double amount;

    public Transaction(Type type, String assetname, double amount) {
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }
        if (assetname == null || assetname.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset name must not be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.type = type;
        this.assetname = assetname;
        this.amount = amount;

        synchronized (Transaction.class) { 
            this.id = counter++;
        }
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getAssetName() {
        return assetname;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + type + " " + assetname + " | Amount: " + amount;
    }
}

