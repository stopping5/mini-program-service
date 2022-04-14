package com.stopping.mini.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodInfoRequestDTO {
    //PageSize=30&PageIndex=1&SearchItem=6914068019529
    private Integer PageSize;

    private Integer PageIndex;

    private String SearchItem;
}
