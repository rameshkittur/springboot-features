package com.rameshkittur.Spring.Boot.Features.repositories;

import com.rameshkittur.Spring.Boot.Features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
