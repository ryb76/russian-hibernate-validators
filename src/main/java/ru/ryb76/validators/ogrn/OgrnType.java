package ru.ryb76.validators.ogrn;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OgrnType
{
    OGRN_UL(13),
    OGRN_IP(15),
    OGRN_ANY(0);

    private int length;
}
