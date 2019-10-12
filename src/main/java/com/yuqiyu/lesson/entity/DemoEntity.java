package com.yuqiyu.lesson.entity;

import com.yuqiyu.lesson.validator.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author fengxiao
 * @date 2019/10/12 13:50
 * @description
 */
@Data
public class DemoEntity implements Serializable {

    @NotBlank
    @Length(min=2,max = 10)
    private String name;
    @Min(value = 1)
    private int age;
    @NotBlank
    @Email
    private String mail;
    @FlagValidator(values = "1,2,3")
    private String flag;

}
