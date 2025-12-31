package model;

public final class Transaction {
    public enum Type { BUY, SELL }

    private final Type type;
    private final String assetname;
    private final double amount; // value of transaction

   public Transaction(Type type, String assetname, double amount) {
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }

        if (assetname == null || assetname.equals("")) {
            throw new IllegalArgumentException("Asset name must not be null or an empty String, enter a valid assetname");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.type = type;
        this.assetname = assetname;
        this.amount = amount;
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
        return type + " " + assetname + " | Amount: " + amount;
    }
}
