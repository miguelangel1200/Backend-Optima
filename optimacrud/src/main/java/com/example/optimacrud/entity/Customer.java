package com.example.optimacrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address" )
    private String address;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "status")
    private String status;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "monthly_income")
    private BigDecimal monthlyIncome;

    @Column(name = "actual_job")
    private String actualJob;

    private String purpose;

    @Column(name = "budget", nullable = false)
    @NotNull
    private BigDecimal budget;

    @Column(name = "kind_of_property", nullable = false)
    @NotNull
    private String kindOfProperty;

    @Column(name = "location", nullable = false)
    private String location;
    private String characteristics;


    // Constructor, getters, and setters (Lombok's @Data annotation takes care of these)

    // Define a static method to get the valid options for status
    public static List<String> getStatusOptions() {
        return List.of("single", "married", "widower");
    }

    // Define a static method to get the valid options for kindOfProperty
    public static List<String> getKindOfPropertyOptions() {
        return List.of("house", "apartment", "land");
    }

}
