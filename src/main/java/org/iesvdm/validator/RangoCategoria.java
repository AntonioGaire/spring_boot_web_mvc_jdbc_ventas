package org.iesvdm.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCategoriaValidator.class)
@Documented
@Repeatable(org.iesvdm.validator.RangoCategoria.List.class)

public @interface RangoCategoria {
	
	int[] value() default {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
	
	String message() default "{error.rangocategoria.outofrange}";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		RangoCategoria[] value();
	}

}
