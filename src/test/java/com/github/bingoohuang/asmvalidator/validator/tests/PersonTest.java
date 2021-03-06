package com.github.bingoohuang.asmvalidator.validator.tests;

import com.github.bingoohuang.asmvalidator.AsmValidateResult;
import com.github.bingoohuang.asmvalidator.AsmValidatorFactory;
import com.github.bingoohuang.asmvalidator.validator.domain.Person;
import com.github.bingoohuang.asmvalidator.ex.AsmValidateException;
import org.junit.Test;

public class PersonTest {
    @Test
    public void pass() {
        Person person = new Person();
        person.setName("1234567890");
        person.setAddr("aaa");
        AsmValidateResult result = AsmValidatorFactory.validate(person);
        result.throwExceptionIfError();
    }

    @Test(expected = AsmValidateException.class)
    public void startup() {
        Person person = new Person();
        AsmValidateResult result = AsmValidatorFactory.validate(person);
        result.throwExceptionIfError();
    }

    @Test(expected = AsmValidateException.class)
    public void tooLong() {
        Person person = new Person();
        person.setName("1234567890123456789012345678901234567890123456789012345678901234567");
        person.setAddr("aaa");
        AsmValidateResult result = AsmValidatorFactory.validate(person);
        result.throwExceptionIfError();
    }
}
