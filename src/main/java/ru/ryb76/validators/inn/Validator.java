package ru.ryb76.validators.inn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<InnValid, String>
{
    private InnType innType;
    private int ulCoefficients[] = {2, 4, 10, 3, 5, 9, 4, 6, 8};
    private int fl2Coefficients[] = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private int fl1Coefficients[] = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public void initialize(InnValid constraintAnnotation)
    {
        this.innType = constraintAnnotation.value();
    }

    public boolean isValid(String inn, ConstraintValidatorContext constraintContext)
    {
        if (inn == null || inn.isEmpty()) return true;
        InnType type = innType;
        if (innType == InnType.INN_ANY)
        {
            if (inn.length() == InnType.INN_UL.getLength()) type = InnType.INN_UL;
            else if (inn.length() == InnType.INN_FL.getLength()) type = InnType.INN_FL;
            else return false;
        }
        return isValid(inn, type);
    }

    private boolean isValid(String inn, InnType innType)
    {
        try
        {
            if (inn.length() != innType.getLength()) throw new Exception();

            switch (innType)
            {
                case INN_UL:
                    int result = 0;
                    for (int i = 0; i < ulCoefficients.length; i++) result += Integer.parseInt("" + inn.charAt(i)) * ulCoefficients[i];
                    result = result % 11 % 10;
                    return result == Integer.parseInt("" + inn.charAt(9));

                case INN_FL:
                    int n2Result = 0, n1Result =0;
                    for (int i = 0; i < fl2Coefficients.length; i++) n2Result += Integer.parseInt("" + inn.charAt(i)) * fl2Coefficients[i];
                    for (int i = 0; i < fl1Coefficients.length; i++) n1Result += Integer.parseInt("" + inn.charAt(i)) * fl1Coefficients[i];
                    n2Result = n2Result % 11 % 10;
                    n1Result = n1Result % 11 % 10;
                    return n1Result == Integer.parseInt("" + inn.charAt(11)) && n2Result == Integer.parseInt("" + inn.charAt(10));

                default:
                    return false;
            }
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}