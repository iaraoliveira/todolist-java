package br.com.iaraoliveira.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private iTaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        var taskCreated = this.taskRepository.save(taskModel);
        return taskCreated;
    }
}
