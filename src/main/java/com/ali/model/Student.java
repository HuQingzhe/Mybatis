package com.ali.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author QingzheHu
 * @date 2021/7/4 20:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private Integer studentSex;
    private Date studentBirthday;
}
