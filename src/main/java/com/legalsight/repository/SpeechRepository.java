package com.legalsight.repository;


import com.legalsight.entity.SpeechEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeechRepository extends JpaRepository<SpeechEntity, String>, JpaSpecificationExecutor<SpeechEntity> {
}
