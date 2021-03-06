package com.github.bingoohuang.asmvalidator.paramvalidator.tests;

import com.github.bingoohuang.asmvalidator.AsmParamsValidatorFactory;
import com.github.bingoohuang.asmvalidator.annotations.AsmTrue;
import com.github.bingoohuang.asmvalidator.annotations.AsmValid;
import com.github.bingoohuang.asmvalidator.ex.AsmValidateException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;

import static com.github.bingoohuang.asmvalidator.AsmParamsValidatorFactory.createValidatorSignature;
import static com.github.bingoohuang.asmvalidator.AsmParamsValidatorFactory.validate;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TrueStringParamTest {
    private static String validatorSignature;

    public interface TrueStringParams {
        @AsmValid
        void something(@AsmTrue String agree);
    }

    @BeforeClass
    public static void beforeClass() {
        Method method = TrueStringParams.class.getMethods()[0];
        AsmParamsValidatorFactory.createValidators(method);
        validatorSignature = createValidatorSignature(method);
    }

    @Test
    public void validYes() {
        validate(validatorSignature, "YES");
    }

    @Test
    public void validNo() {
        try {
            validate(validatorSignature, "no");
            fail();
        } catch (AsmValidateException e) {
            assertTrue(e.getMessage().contains("必须为真"));
        }
    }
}
