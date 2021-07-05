package com.ali.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QingzheHu
 * @date 2021/7/2 17:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String userId;
    private String userName;
    private String userPassword;

}
