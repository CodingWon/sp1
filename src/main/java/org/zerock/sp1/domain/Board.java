package org.zerock.sp1.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private Integer bno;
    private String title;
    private String content;
    private String writer;
}
