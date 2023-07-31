package cn.teamhelper.library.controller;

import cn.teamhelper.library.service.IStudentUserService;

public class StudentUserController {
    private final IStudentUserService studentUserService;

    public StudentUserController(IStudentUserService studentUserService) {
        this.studentUserService = studentUserService;
    }

    public boolean login(String username, String password) {
        return studentUserService.login(username, password);
    }
}
