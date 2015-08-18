package com.github.bingoohuang.asmvalidator.validator.tests;

import com.github.bingoohuang.asmvalidator.AsmValidateResult;
import com.github.bingoohuang.asmvalidator.AsmValidator;
import com.github.bingoohuang.asmvalidator.ValidateError;
import com.github.bingoohuang.asmvalidator.validator.domain.Person3;
import com.github.bingoohuang.asmvalidator.utils.AsmConsts;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class AsmValidatorPersonImpl implements AsmValidator<Person3> {
    public AsmValidateResult validate(Person3 bean) {
        AsmValidateResult result = new AsmValidateResult();
        int intAge = bean.getAge();
        String age = String.valueOf(intAge);
        boolean argNull = age == null;

        if (isBlank(age))
            result.addError(new ValidateError("name", age, "不能为空"));

        if (!argNull && age.length() > AsmConsts.DEFAULT_MAX_SIZE) {
            result.addError(new ValidateError("age", age, "长度超过" + AsmConsts.DEFAULT_MAX_SIZE));
        }

        if (argNull || age.length() != 3) {
            result.addError(new ValidateError("age", age, "长度不等于3"));
        }

        String addr = bean.getAddr();
        boolean addrNull = addr == null;

        if (isBlank(addr))
            result.addError(new ValidateError("addr", addr, "不能为空"));
        if (addr != null && addr.length() > AsmConsts.DEFAULT_MAX_SIZE) {
            result.addError(new ValidateError("addr", addr, "长度超过" + AsmConsts.DEFAULT_MAX_SIZE));
        }

        if (addrNull || addr.length() < 150) {
            result.addError(new ValidateError("addr", addr, "长度小于3"));
        }

        if (!addrNull && !addr.matches("abc")) {
            result.addError(new ValidateError("addr", addr, "格式错误"));
        }

        return result;
    }
}