package com.example.Dukaan.shop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Shop name is required")
    @Size(max = 100 , message =  "Shop name cannot exceed 100 characters")
    private String shopName;

    @NotBlank(message ="Owner name is required")
    @Size(max = 100 , message =  "Owner name cannot exceed 100 characters")
    private String ownerName;

    @NotBlank(message = "Address name is required")
    @Size(max = 100 , message =  "Address name cannot exceed 100 characters")
    private String shopAddress;

    @NotBlank(message = "City is required")
    @Size(max = 100 , message =  "City cannot exceed 100 characters")
    private String city;

    @NotBlank(message = "State name is required")
    @Size(max = 100 , message =  "State name cannot exceed 100 characters")
    private String state;

    @NotBlank(message = "Pin Code is required")
    @Pattern(regexp = "\\d{6}" , message =  "Pin Code must contain 6 digits")
    private String pincode;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}" , message = "Phone number must contain 10 digits")
    private String phoneNumber;

    @Email(message = "Enter a valid email eddress")
    private String email;

    @NotBlank(message = "GST number is required")
    @Size(max = 15, message = "GST number cannot exceed 15 characters")
    private String gstNumber;

    private Boolean softDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Boolean getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Boolean softDelete) {
        this.softDelete = softDelete;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
}
