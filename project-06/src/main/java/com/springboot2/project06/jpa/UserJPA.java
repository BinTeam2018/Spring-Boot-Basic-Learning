package com.springboot2.project06.jpa;

import com.springboot2.project06.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {

    @Query(value = "select id from user where name = ?1 and pwd = ?2",nativeQuery = true)
    int findOneByName(String name, String pwd);
}
