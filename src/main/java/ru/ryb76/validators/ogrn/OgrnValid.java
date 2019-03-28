package ru.ryb76.validators.ogrn;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Validator.class)
@Documented
public @interface OgrnValid
{
    String message() default "{ru.ryb76.validators.OGRN.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    OgrnType value();
}
