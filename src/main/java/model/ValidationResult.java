package model;

import java.util.Collections;
import java.util.List;

public final class ValidationResult {

    private final boolean ok;
    private final List<RejectionReason> reasons;

    private ValidationResult(boolean ok, List<RejectionReason> reasons) {
        this.ok = ok;
        this.reasons = reasons == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(reasons);
    }

    public static ValidationResult ok() {
        return new ValidationResult(true, Collections.emptyList());
    }

    public static ValidationResult rejected(List<RejectionReason> reasons) {
        return new ValidationResult(false, reasons);
    }

    public boolean isOk() {
        return ok;
    }

    public List<RejectionReason> getReasons() {
        return reasons;
    }
}

