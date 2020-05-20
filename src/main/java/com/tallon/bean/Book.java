package com.tallon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * book
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-05-20 23:20
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    private String name;

    /**
     * 描述
     */
    private String author;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
