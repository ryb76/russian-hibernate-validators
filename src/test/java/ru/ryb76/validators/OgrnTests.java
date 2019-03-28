package ru.ryb76.validators;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.ryb76.validators.beans.inn.InnFLBean;
import ru.ryb76.validators.beans.ogrn.OgrnAnyBean;
import ru.ryb76.validators.beans.ogrn.OgrnIPBean;
import ru.ryb76.validators.beans.ogrn.OgrnULBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class OgrnTests
{
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidIpOgrn()
    {
        InnFLBean bean = new InnFLBean("123456789012345");
        Set<ConstraintViolation<InnFLBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidIpOgrn()
    {
        OgrnIPBean bean = new OgrnIPBean("312230810800101");
        Set<ConstraintViolation<OgrnIPBean>> constraintViolations = validator.validate(bean);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testInvalidUlOgrn()
    {
        OgrnULBean bean = new OgrnULBean("1234567890123");
        Set<ConstraintViolation<OgrnULBean>> constraintViolations = validator.validate(bean);
        assertEquals("is not valid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testValidUlOgrn()
    {
        OgrnULBean bean = new OgrnULBean("1027601106169");
        Set<ConstraintViolation<OgrnULBean>> constraintViolations = validator.validate(bean);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testInvalidAnyOgrn()
    {
        OgrnAnyBean bean1 = new OgrnAnyBean("123456789012345");
        Set<ConstraintViolation<OgrnAnyBean>> constraintViolations1 = validator.validate(bean1);
        assertEquals("is not valid", constraintViolations1.iterator().next().getMessage());

        OgrnAnyBean bean2 = new OgrnAnyBean("1234567890123");
        Set<ConstraintViolation<OgrnAnyBean>> constraintViolations2 = validator.validate(bean2);
        assertEquals("is not valid", constraintViolations2.iterator().next().getMessage());
    }

    @Test
    public void testValidAnyOgrn()
    {
        OgrnAnyBean bean1 = new OgrnAnyBean("312230810800101");
        Set<ConstraintViolation<OgrnAnyBean>> constraintViolations1 = validator.validate(bean1);
        assertEquals(0, constraintViolations1.size());

        OgrnAnyBean bean2 = new OgrnAnyBean("1027601106169");
        Set<ConstraintViolation<OgrnAnyBean>> constraintViolations2 = validator.validate(bean2);
        assertEquals(0, constraintViolations2.size());
    }
}
