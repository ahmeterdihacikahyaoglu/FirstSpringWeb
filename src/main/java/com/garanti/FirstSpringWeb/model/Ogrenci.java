package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ogrenci {
    private Integer ID;

    @NonNull
    private String NAME;

    @NonNull
    private int OGR_NUMBER;

    @NonNull
    private Integer YEAR;
}
