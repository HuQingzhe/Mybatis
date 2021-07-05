package com.ali.job;

import com.ali.model.Student;
import com.ali.service.StudentService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author QingzheHu
 * @date 2021/7/5 8:22
 */
public class MyJob implements Job {
    @Resource
    private StudentService studentService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        List<Student> studentList = studentService.findAllStudents();
    }
}
