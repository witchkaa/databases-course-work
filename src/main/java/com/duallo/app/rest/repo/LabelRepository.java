package com.duallo.app.rest.repo;

import com.duallo.app.rest.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> findByTaskID(Long taskID);
    List<Label> findByTagID(Long tagID);
    Optional<Label> findByTaskIDAndTagID(Long taskID, long tagID);
}
