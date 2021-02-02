package com.lottery.lottery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="Customer")
public class User {

    private static final long serialVersion = 1L;

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @Column(unique = true)
    @NonNull
    private String email;
}
