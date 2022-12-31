package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ogretmen {
    private Integer ID;

    @NonNull
    private String NAME;

    @NonNull
    private boolean IS_GICIK;
}