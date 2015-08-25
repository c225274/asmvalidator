package com.github.bingoohuang.asmvalidator.annotations;

import com.github.bingoohuang.asmvalidator.validation.AsmSizeValidateGenerator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

import static java.lang.annotation.ElementType.*;

@Documented
@AsmConstraint(
        supportedClasses = {String.class, int.class, long.class, Collection.class},
        asmValidateBy = AsmSizeValidateGenerator.class,
        message = "长度不等于{value}")
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AsmSize {
    int value();
}
