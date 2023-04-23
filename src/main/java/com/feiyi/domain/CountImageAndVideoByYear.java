package com.feiyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountImageAndVideoByYear {
    private String year;
    private int countImages;
    private int countVideos;
}
