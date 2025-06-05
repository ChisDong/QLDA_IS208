package com.hctt.is208.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class candidates {
    @Id
    private int id;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @Column(name = "cv_file_path")
    private String cvFilePath;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private users user;
} 