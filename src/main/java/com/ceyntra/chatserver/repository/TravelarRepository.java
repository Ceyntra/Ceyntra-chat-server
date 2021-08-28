package com.ceyntra.chatserver.repository;

import com.ceyntra.chatserver.model.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelarRepository extends JpaRepository<Traveller,Integer> {

    @Query("Select t from Traveller t where t.traveller_id=:traveller_id")
    Traveller findByTraveller_id(@Param("traveller_id") int traveller_id);

}
