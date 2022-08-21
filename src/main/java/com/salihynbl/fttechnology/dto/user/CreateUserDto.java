package com.salihynbl.fttechnology.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @Length(max = 50, message = "İsim maximum 50 karakter olabilir.")
    @NotBlank(message = "Ad alanı boş bırakılamaz.")
    private String firstName;

    @Length(max = 50, message = "Soyisim maximum 50 karakter olabilir.")    @NotBlank(message = "Soyisim alanı boş bırakılamaz.")
    private String lastName;

    @Length(max = 50, message = "Email maximum 50 karakter olabilir.")
    @NotBlank(message = "Email alanı boş bırakılamaz.")
    private String email;

    @NotBlank(message = "Telefon alanı boş bırakılamaz.")
    @Pattern(regexp="[\\d]{11}", message = "Telefon numarası 11 karakter ve sadece rakamlardan oluşabilir.")
    private String phoneNumber;
}
