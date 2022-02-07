package com.db.batchScheduler.service;

import com.db.batchScheduler.dao.SchedulerRepository;
import com.db.batchScheduler.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    public void readData(){
        Ticket ticket = schedulerRepository.findById(14);
        System.out.println(ticket);
    }

    public Ticket getTicketDataById(int num){
        Ticket ticket = schedulerRepository.findById(num);
        if(ticket !=null){
            return ticket;
        }
        return ticket;
    }

    public List<Ticket> getAllTicketData(){
        return schedulerRepository.findAll();
    }
}
