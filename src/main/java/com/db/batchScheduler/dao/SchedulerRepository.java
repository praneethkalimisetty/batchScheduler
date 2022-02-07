package com.db.batchScheduler.dao;

import com.db.batchScheduler.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Ticket, Integer> {

    Ticket findById(int id);

}
