package ru.ryb76.validators.beans.inn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ryb76.validators.inn.InnType;
import ru.ryb76.validators.inn.InnValid;

@Getter
@Setter
@AllArgsConstructor
public class InnFLBean
{
    @InnValid(value = InnType.INN_FL)
    private String inn;
}
