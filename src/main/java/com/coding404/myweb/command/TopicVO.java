package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TopicVO {

    private int topicId;
    private LocalDateTime topicRegdate;
    private String topicWriter;
    private String topicTitle;
    private String topicContent;
}
