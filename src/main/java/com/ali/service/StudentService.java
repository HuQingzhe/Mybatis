package com.ali.service;

import com.ali.model.Student;

import java.util.List;

/**
 * @author QingzheHu
 * @date 2021/7/4 20:37
 */

public interface StudentService {

    /**
     * 查询数据库中所有的学生对象
     * @return 返回一个学生集合
     */
    List<Student> findAllStudents();

    /**
     * 将student对象插入进数据库
     * @param student 前端传递的student对象
     */
    void insert(Student student);
}
