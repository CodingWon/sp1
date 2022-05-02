package org.zerock.sp1.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Reply {
    private Integer rno;
    private Integer bno;
    private String replyText;
    private String replyer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
