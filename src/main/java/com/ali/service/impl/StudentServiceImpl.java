package com.ali.service.impl;

import com.ali.mapper.StudentMapper;
import com.ali.model.Student;
import com.ali.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author QingzheHu
 * @date 2021/7/4 20:45
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public List<Student> findAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }
}
