package com.papeleriamibarrio.backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable =  false)
    private int Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String business;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = true)
    private String phoneNumber;
}
