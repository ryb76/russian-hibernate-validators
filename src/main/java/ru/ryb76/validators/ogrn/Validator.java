package ru.ryb76.validators.ogrn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<OgrnValid, String>
{
    private OgrnType ogrnType;

    @Override
    public void initialize(OgrnValid constraintAnnotation)
    {
        this.ogrnType = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String ogrn, ConstraintValidatorContext constraintContext)
    {
        if (ogrn == null || ogrn.isEmpty()) return true;
        OgrnType type = ogrnType;
        if (ogrnType == OgrnType.OGRN_ANY)
        {
            if (ogrn.length() == OgrnType.OGRN_UL.getLength()) type = OgrnType.OGRN_UL;
            else if (ogrn.length() == OgrnType.OGRN_IP.getLength()) type = OgrnType.OGRN_IP;
            else return false;
        }
        return isValid(ogrn, type);
    }

    private boolean isValid(String ogrn, OgrnType ogrnType)
    {
        try
        {
            if (ogrn.length() != ogrnType.getLength()) throw new Exception();
            long result = Long.parseLong(ogrn.substring(0, ogrnType.getLength() - 1)) % (ogrnType.getLength() - 2) % 10;
            return result == Long.parseLong(ogrn.substring(ogrnType.getLength() - 1));
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}