package com.kiduyu.nahashonproject.realestateagent.data.dao;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kiduyu.nahashonproject.realestateagent.data.entities.Agent;

import java.util.List;

/**
 * Created by Diego Fajardo (https://github.com/diegomfv) on 06/10/2018.
 */
@Dao
public interface AgentDao {

    // -------------------
    // READ

    @Query("SELECT * FROM agent ORDER BY email")
    List<Agent> getAllAgents();

    // -------------------
    // INSERT
    @Insert
    long insertAgent(Agent agent);

    // -------------------
    // UPDATE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateAgent(Agent agent);

    // -------------------
    // DELETE


}
