package com.github.bingoohuang.asmvalidator;

import com.github.bingoohuang.asmvalidator.domain.UUIDBean;
import org.junit.Test;

public class AsmUUIDTest {

    @Test
    public void testEx() {
        UUIDBean UUIDBean = new UUIDBean();
        UUIDBean.setUuid("123456789");

        AsmValidateResult result = AsmValidatorFactory.validate(UUIDBean);
        result.throwExceptionIfError();

    }

    @Test
    public void testOk() {
        UUIDBean UUIDBean = new UUIDBean();
        UUIDBean.setUuid("87E35233-DD9D-4250-A32C-114BFD456709");

        AsmValidateResult result = AsmValidatorFactory.validate(UUIDBean);
        result.throwExceptionIfError();

    }


}
