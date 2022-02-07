package com.db.batchScheduler.controller;

import com.db.batchScheduler.model.Ticket;
import com.db.batchScheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    SchedulerService service;

    @GetMapping(value = "/{id}")
    public String getTicketData(@PathVariable(value = "id", required = false) int id){
        Ticket ticket = service.getTicketDataById(id);
        if(ticket != null){
            return ticket.toString();
        }
        return "Data not available";
    }

    @GetMapping(value = "/")
    public List<Ticket> getAllData(){
        return service.getAllTicketData();
    }

    @GetMapping(value = {"/consumeApi", "/consumeApi/{id}"})
    public String readDataFromApi(@PathVariable(value = "id", required = false) String id){

        if(id != null){
            RestTemplate restTemplate = new RestTemplate();

            String ticket = restTemplate.getForObject("http://localhost:8080/"+id, String.class);

            if(ticket !=null){
                return ticket.toString();
            }
        }
        return "Data Not Available";
    }
}
