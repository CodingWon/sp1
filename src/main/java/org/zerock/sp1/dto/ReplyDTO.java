package org.zerock.sp1.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyDTO {
    private Integer rno;
    private Integer bno;
    private String replyText;
    private String replyer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
