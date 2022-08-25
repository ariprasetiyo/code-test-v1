package id.arprast.ref;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {

    @JsonProperty("meminjam")
    MEMINJAM("meminjam", "meminjam"),
    @JsonProperty("menyerahkan")
    MENYERAHKAN("menyerahkan", "menyerahkan"),
    @JsonProperty("mengambil")
    MENGAMBIL("mengambil", "mengambil");

    public final String id;
    public final String desc;

    TransactionType(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static TransactionType valueOfId(String id) {
        switch (id) {
            case "meminjam":
                return MEMINJAM;
            case "menyerahkan":
                return MENYERAHKAN;
            case "mengambil":
                return MENGAMBIL;
            default:
                return null;
        }
    }
}
