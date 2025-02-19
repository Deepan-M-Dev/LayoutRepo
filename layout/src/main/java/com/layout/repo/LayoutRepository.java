package com.layout.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.layout.model.Layout;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, Long> {
}
