package com.dharma.spring.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone paramA) {
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if(phoneNo == null){
			return false;
		}
        if (phoneNo.matches("\\d{10}")) {
			return true;
		} else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
		    return true;
        } else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
		    return true;
        } else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
		    return true;
        } else {
		    return false;
        }
	}

}
