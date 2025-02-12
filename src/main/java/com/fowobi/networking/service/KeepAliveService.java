package com.fowobi.networking.service;

import com.fowobi.networking.dto.KeepAlive;
import com.fowobi.networking.model.KeepAliveEntity;
import com.fowobi.networking.repository.KeepAliveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class KeepAliveService {

    @Autowired
    KeepAliveRepo repository;

    public KeepAliveEntity save(KeepAlive keepAlive) {
        KeepAliveEntity keepAliveEntity = new KeepAliveEntity();
        keepAliveEntity.setDepartment(keepAlive.getDepartment());
        keepAliveEntity.setHost(keepAlive.getHost());
        keepAliveEntity.setTime(new Date());

        return repository.save(keepAliveEntity);
    }

    public List<KeepAliveEntity> getAll() {
        return repository.findAll();
    }

    public List<KeepAliveEntity> findByHostName(String hostName) {
        return repository.findByHost(hostName);
    }

}
