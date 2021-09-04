package com.ceyntra.chatserver.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    private int userId;
    private String email;
    private String telephone;
    private int userType;
    private String hashedPassword;


}
