# batchScheduler

Scheduled to Run for every 5 seconds

This uses a Ticket database to read the data from Ticket Database

It contains both producer & consumer api

It consmues the same API developed internally to read the data from Ticket DB

URL's

http://localhost:8080/                    ==> to fetch all data present in DB from table ticket
http://localhost:8080/{id}                ==> provides data based on id provided if available
http://localhost:8080/consumeApi/{id}     ==> uses restTemplate to fetch data own API
