package com.ali.controller;

import com.ali.model.Student;
import com.ali.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author QingzheHu
 * @date 2021/7/4 19:56
 */

@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("show")
    public String show(Model model) {
        List<Student> studentList = studentService.findAllStudents();
        model.addAttribute("studentList",studentList);
        return "showStudent";
    }

    @RequestMapping("gotoAddPage")
    public String gotoAddPage(){
        return "add";
    }

    @RequestMapping("addStudent")
    public String addStudent(Student student){
        try {
            studentService.insert(student);
            return "redirect:/student/show";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "add";
    }

}
