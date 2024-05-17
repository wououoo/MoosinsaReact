package react.project.moosinsa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/test")
    public String hello(){
        return "A";
    }

}

