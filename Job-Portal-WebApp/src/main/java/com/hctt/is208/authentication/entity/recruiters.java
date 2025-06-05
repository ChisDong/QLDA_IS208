package com.hctt.is208.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruiters")
public class recruiters {
    @Id
    private int id;

    @Column(name = "company_name")
    private String companyName;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private users user;
} 