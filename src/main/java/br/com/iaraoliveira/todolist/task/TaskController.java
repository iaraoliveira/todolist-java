package br.com.iaraoliveira.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private iTaskRepository taskRepository;

    @PostMapping("/")
    public void create(@RequestBody TaskModel taskModel) {
        // var user = this.taskRepository.findByUsername(userModel.getUsername());

        // if (user != null) {
        //     System.out.println("Este usuário já existe.");
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        // }

        // var PasswordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        // userModel.setPassword(PasswordHashed);

        var taskCreated = this.taskRepository.save(taskModel);
        // return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
