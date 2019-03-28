package ru.ryb76.validators.beans.snils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ryb76.validators.snils.SnilsValid;

@Getter
@Setter
@AllArgsConstructor
public class SnilsBean
{
    @SnilsValid
    private String snils;
}
