package task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import task.domains.Request;
import task.domains.Response;
import task.service.CollisionService;

import java.util.Arrays;
import java.util.List;

@RestController
public class CollisionController {

    private final CollisionService collisionService;

    @Autowired
    public CollisionController(CollisionService collisionService) {
        this.collisionService = collisionService;
    }

    @PostMapping("getCollisions")
    public Response searchCollision(@RequestBody Request words) {
        return null;
    }
}
