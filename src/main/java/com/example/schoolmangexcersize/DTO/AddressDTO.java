package com.example.schoolmangexcersize.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer id;

    private Integer teacher_id;

    @NotEmpty
    private String state;

    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private String buildingNumber;
}
