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
@Table(name = "traveller")
public class Traveller {

    @Id
    private int traveller_id;
    private String nic;
    private String first_name;
    private String last_name;
    private String profile_photo;


}
