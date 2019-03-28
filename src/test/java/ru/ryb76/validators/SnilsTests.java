package ru.ryb76.validators;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.ryb76.validators.beans.snils.SnilsBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SnilsTests
{
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidSnils()
    {
        SnilsBean bean = new SnilsBean("123-456-789 01");
        Set<ConstraintViolation<SnilsBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidSnils()
    {
        SnilsBean bean = new SnilsBean("116-973-385 89");
        Set<ConstraintViolation<SnilsBean>> constraintViolations = validator.validate(bean);
        assertEquals(0, constraintViolations.size());
    }
}
