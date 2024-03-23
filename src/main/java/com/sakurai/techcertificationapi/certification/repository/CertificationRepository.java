package com.sakurai.techcertificationapi.certification.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sakurai.techcertificationapi.certification.model.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, UUID> {

    @Query("""
        SELECT c
        FROM Certification c
        WHERE c.technology = :technology
        ORDER BY c.grade DESC
    """)
    public Page<Certification> findGreatestGradesByTechnology(String technology, Pageable quantity);

}
