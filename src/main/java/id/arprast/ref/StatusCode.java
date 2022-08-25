package id.arprast.ref;

public enum StatusCode {

    SUCCESS(1, "success"),
    FAILED(2, "failed"),
    AMOUNT_NEGATIVE(3, "amount negative"),
    MINIMUN_NAME_THREE_CHAR(4, "minimun name 3 char"),
    NOT_FOUND(404, "data not found");

    public final int intValue;
    public final String desc;

    /**
     * @param intValue
     * @param desc
     */
    StatusCode(int intValue, String desc) {
        this.intValue = intValue;
        this.desc = desc;
    }

    public static StatusCode valueOf(int intValue) {
        switch (intValue) {
            case 1:
                return SUCCESS;
            case 2:
                return FAILED;
            case 404:
                return NOT_FOUND;
            default:
                return null;
        }
    }
}
