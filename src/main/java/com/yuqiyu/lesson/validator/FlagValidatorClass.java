package com.yuqiyu.lesson.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author fengxiao
 * @date 2019/10/12 14:10
 * @description
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {

    private String values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
      this.values=constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String[] strs=values.split(",");
        boolean isFlag=false;
        for ( String str : strs) {
            if(str.equals(o)){
                isFlag=true;
                break;
            }
        }
        return isFlag;
    }
}
