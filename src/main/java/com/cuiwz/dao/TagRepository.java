package com.cuiwz.dao;

import com.cuiwz.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuiwz on 2020/02/22.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);
}
