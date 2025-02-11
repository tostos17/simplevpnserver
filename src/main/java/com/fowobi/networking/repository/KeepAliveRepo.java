package com.fowobi.networking.repository;

import com.fowobi.networking.model.KeepAliveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeepAliveRepo extends JpaRepository<KeepAliveEntity, Long> {
    List<KeepAliveEntity> findByHost(String hostName);
}
