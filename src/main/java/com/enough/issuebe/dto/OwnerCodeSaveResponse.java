package com.enough.issuebe.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerCodeSaveResponse {

    private int savedCount;
    private List<OwnerCodeInfResponse> savedRows;
}
