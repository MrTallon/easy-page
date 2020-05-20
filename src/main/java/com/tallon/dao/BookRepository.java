package com.tallon.dao;

import com.tallon.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * dao层
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-05-20 23:30
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    /**
     * 根据sort和time字段排序查询
     * @return {@Book}
     */
    @Query("select name,author from Book order by sort,createTime ")
    List<Book> sortList();
}
