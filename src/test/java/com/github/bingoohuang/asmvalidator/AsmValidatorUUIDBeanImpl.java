package com.github.bingoohuang.asmvalidator;

import com.github.bingoohuang.asmvalidator.domain.UUIDBean;

public class AsmValidatorUUIDBeanImpl implements AsmValidator<UUIDBean> {
    @Override
    public AsmValidateResult validate(UUIDBean bean) {
        AsmValidateResult result = new AsmValidateResult();

        validateUuid(bean, result);
        validateUuid2(bean, result);

        return result;
    }

    private void validateUuid(UUIDBean bean, AsmValidateResult result) {
        String uuid = bean.getUuid();
        boolean var4 = uuid == null;
        if (var4 || uuid.length() != 36) {
            result.addError(new ValidatorError("uuid", "长度不等于36"));
            return;
        }

        if (!var4 && !uuid.matches("\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}")) {
            result.addError(new ValidatorError("uuid", "格式错误"));
            return;
        }

    }

    private void validateUuid2(UUIDBean bean, AsmValidateResult result) {
        String uuid = bean.getUuid2();
        boolean var4 = uuid == null;
        if (var4 || uuid.length() != 36) {
            result.addError(new ValidatorError("uuid", "长度不等于36"));
            return;
        }

        if (!var4 && !uuid.matches("\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}")) {
            result.addError(new ValidatorError("uuid", "格式错误"));
            return;
        }

    }
}