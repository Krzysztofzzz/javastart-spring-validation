package com.javastart.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SerialNoValidator implements ConstraintValidator<SerialNo, String> {
    private String startsWith;
    private int codeLength;

    @Override
    public void initialize(SerialNo constraintAnnotation) {
        startsWith = constraintAnnotation.startsWith();
        codeLength = constraintAnnotation.codeLength();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return checkPrefix(s) && checkCodeLength(s) && checkCode(s);
    }

    private boolean checkPrefix(String serialNo) {
        return serialNo.startsWith(startsWith);
    }

    private boolean checkCodeLength(String serialNo) {
        int prefixLength = startsWith.length();
        int serialNumberLength = serialNo.length();
        return serialNumberLength - prefixLength == codeLength;
    }

    private boolean checkCode(String serialNo) {
        int prefixLength = startsWith.length();
        char[] serialNumberCode = serialNo.substring(prefixLength).toCharArray();
        for (char c : serialNumberCode) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
