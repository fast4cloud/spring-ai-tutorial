package com.spring.ai.tutorial.outparser.model.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author yingzi
 * @date 2025/5/22 22:17
 */
@JsonPropertyOrder({"title", "date", "author", "content"}) // 指定属性的顺序
public record BeanEntity(String title, String author,
                         String date, String content) {
}
