package ru.ryb76.validators;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.ryb76.validators.beans.inn.InnAnyBean;
import ru.ryb76.validators.beans.inn.InnFLBean;
import ru.ryb76.validators.beans.inn.InnULBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class InnTests
{
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidFlInn()
    {
        InnFLBean bean = new InnFLBean("123456789012");
        Set<ConstraintViolation<InnFLBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidFlInn()
    {
        InnFLBean bean = new InnFLBean("745105884167");
        Set<ConstraintViolation<InnFLBean>> constraintViolations = validator.validate(bean);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testInvalidUlInn()
    {
        InnULBean bean = new InnULBean("1234567890");
        Set<ConstraintViolation<InnULBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidUlInn()
    {
        InnULBean bean = new InnULBean("7610052644");
        Set<ConstraintViolation<InnULBean>> constraintViolations = validator.validate(bean);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testInvalidAnyInn()
    {
        InnAnyBean bean = new InnAnyBean("123456789012");
        Set<ConstraintViolation<InnAnyBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());

        bean = new InnAnyBean("1234567890");
        constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidAnyInn()
    {
        InnAnyBean bean1 = new InnAnyBean("745105884167");
        Set<ConstraintViolation<InnAnyBean>> constraintViolations1 = validator.validate(bean1);
        assertEquals(0, constraintViolations1.size());

        InnAnyBean bean2 = new InnAnyBean("7610052644");
        Set<ConstraintViolation<InnAnyBean>> constraintViolations2 = validator.validate(bean2);
        assertEquals(0, constraintViolations2.size());
    }
}
