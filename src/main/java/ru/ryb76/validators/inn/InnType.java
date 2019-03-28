package ru.ryb76.validators.inn;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InnType
{
    INN_UL(10),
    INN_FL(12),
    INN_ANY(0);

    private int length;
}
