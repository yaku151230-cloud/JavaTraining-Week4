package com.example.taskapp.controller;

import com.example.taskapp.entity.Task;
import com.example.taskapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// タスク管理の画面表示を担当するコントローラーを作成  
@Controller
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    // タスクの一覧表示
    @GetMapping("/tasks")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("task", new Task());
        return "tasks/index";
    }

    // タスクの新規登録画面表示
    @GetMapping("/tasks/new")
    public String newTask(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("task", new Task());
        return "tasks/form";
    }

    // タスクの編集画面表示
    @GetMapping("/tasks/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "tasks/form";
    }

    // タスクの登録・更新処理
    @PostMapping("/tasks")
    public String create(
        @Validated @ModelAttribute Task task,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes attributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tasks", taskService.findAll());
            return "tasks/form";
        }

        taskService.save(task);
        attributes.addFlashAttribute("success", "タスクを登録しました");
        return "redirect:/tasks";
    }
    
    // タスクの更新処理
    @PostMapping("/tasks/{id}")
    public String update(
        @PathVariable Long id,
        @Validated @ModelAttribute Task task,
        BindingResult bindingResult,
        RedirectAttributes attributes
    ) {
        if (bindingResult.hasErrors()) {
            return "tasks/form";
        }

        task.setId(id);
        taskService.save(task);
        attributes.addFlashAttribute("success", "タスクを更新しました");
        return "redirect:/tasks";
    }

    // タスクの削除処理
    @PostMapping("/tasks/{id}/delete")
    public String delete(
        @PathVariable Long id,
        RedirectAttributes attributes
    ) {
        taskService.delete(id);
        attributes.addFlashAttribute("success", "タスクを削除しました");
        return "redirect:/tasks";
    }
}
