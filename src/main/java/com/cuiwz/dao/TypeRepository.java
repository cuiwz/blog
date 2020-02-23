package com.cuiwz.dao;

import com.cuiwz.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuiwz on 2020/02/22.
 */
public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);
}
