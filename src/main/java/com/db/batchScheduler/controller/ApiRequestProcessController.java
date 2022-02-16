package com.db.batchScheduler.controller;

import com.db.batchScheduler.exception.ApiRequestException;
import com.db.batchScheduler.model.Ticket;
import com.db.batchScheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ApiRequestProcessController {

    @Autowired
    SchedulerService service;

//    @Autowired
//    private EmailService emailService;

    @GetMapping(value = {"/", "/{id}"})
    public String getTicketData(@PathVariable(value = "id", required = false) String id){

        System.out.println("Id : " + id);
        if(id != null && id.trim().length() > 0 && !id.equalsIgnoreCase("null")){

            int num = Integer.parseInt(id);

            Ticket ticket = service.getTicketDataById(num);

            if(ticket != null)
                return ticket.toString();
            else
                throw new ApiRequestException("Requested Id is not present in the records");
        } else {
            throw new ApiRequestException("Id is missing in the path parameters");
        }

    }

    @GetMapping(value = "/getAll")
    public List<Ticket> getAllData(){

        List<Ticket> ticketsList= service.getAllTicketData();

        if(ticketsList != null) {
            return ticketsList;
        } else {
            throw new ApiRequestException("Request Data Not Available");
        }

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

//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail() throws MessagingException {
//
//        emailService.sendEmailWithAttachment("spring.email.to@gmail.com",
//                "This is Email Body with Attachment...",
//                "This email has attachment",
//                "C:\\Users\\prane\\Pictures\\c.gif");
//
//    }
}
