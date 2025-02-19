package com.layout.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.layout.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}

