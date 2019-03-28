package ru.ryb76.validators.snils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<SnilsValid, String>
{
    private final int SNILS_LENGTH = 11;

    @Override
    public void initialize(SnilsValid constraintAnnotation)
    {
    }

    @Override
    public boolean isValid(String snils, ConstraintValidatorContext constraintContext)
    {
        if (snils == null || snils.isEmpty()) return true;
        return isValid(snils);
    }

    private boolean isValid(String snils)
    {
        try
        {
            snils = snils.replace("-", "").replace(" ", "");

            if (snils.length() != SNILS_LENGTH) throw new Exception();

            String number = snils.substring(0, SNILS_LENGTH - 2);

            //Проверка контрольного числа Страхового номера проводится только для номеров больше 001-001-998
            if (Long.parseLong(number) <= 1001998L) return true;

            int result = 0;
            for (int i = 0; i < SNILS_LENGTH - 2; i++) result += Integer.parseInt("" + number.charAt(i)) * (SNILS_LENGTH - 2 - i);
            result = result % 101 % 100;

            return Integer.parseInt(snils.substring(SNILS_LENGTH - 2)) == result;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}