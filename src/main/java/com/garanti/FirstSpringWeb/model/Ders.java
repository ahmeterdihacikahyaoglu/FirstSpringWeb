package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ders {
    private Integer ID;

    // bu bir foreign key 'dir
    @NonNull
    private Integer OGR_ID;

    // bu bir foreign key 'dir
    @NonNull
    private Integer KONU_ID;
}
