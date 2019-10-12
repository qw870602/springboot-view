package com.yuqiyu.lesson.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author fengxiao
 * @date 2019/10/12 14:07
 * @description 自定义字段验证注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    String values();
    String message() default "flag不存在";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
