package com.layout.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.layout.model.UserGroup;

@Repository
public interface UserGroupMappingRepository extends JpaRepository<UserGroup, Long> {
    List<UserGroup> findByUserId(Long userId);
}

