package ru.ryb76.validators.beans.ogrn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ryb76.validators.ogrn.OgrnType;
import ru.ryb76.validators.ogrn.OgrnValid;

@Getter
@Setter
@AllArgsConstructor
public class OgrnAnyBean
{
    @OgrnValid(value = OgrnType.OGRN_ANY)
    private String ogrn;
}
