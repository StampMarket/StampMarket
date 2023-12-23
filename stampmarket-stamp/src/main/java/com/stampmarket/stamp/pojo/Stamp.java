package com.stampmarket.stamp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stamp {
    private Integer id;
    private String name;
    private String description;
    private Integer width;
    private Integer height;
    private LocalDate publishDate;
    private Integer price;
}
