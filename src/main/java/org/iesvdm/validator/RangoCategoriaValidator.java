package org.iesvdm.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, Integer>{
	
	private int[] possibleValues;

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean isValid = false;
		String mensajeError= "value out of list";
		
		for( int pv : possibleValues) {
			if(value==pv) {
				isValid = true;
			}
		}
		
        if ( !isValid ) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(mensajeError)
            .addConstraintViolation();
        }
		
		return isValid;
	}
	
	@Override
	public void initialize(RangoCategoria constraintAnnotation) {
		this.possibleValues = constraintAnnotation.value();
	}

}
