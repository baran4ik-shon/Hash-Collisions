package task.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import task.domains.Request;
import task.domains.Response;
import task.service.CollisionService;

import java.io.IOException;

@RestController
public class CollisionController {

    private final CollisionService collisionService;

    @Autowired
    public CollisionController(CollisionService collisionService) {
        this.collisionService = collisionService;
    }

    /**
     * accepts an array of strings and returns the sets of strings which collide in the hash table
     * @param requestBody - request from client
     * @return - list with collisions
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Response searchCollision(@RequestBody String requestBody) {
        try {
            Request request = new ObjectMapper().readValue(requestBody, Request.class);
            return collisionService.searchCollision(request.getInList());
        } catch (IOException e) {
            throw new IllegalStateException("Please, enter correct data in json format");
        }
    }
}
