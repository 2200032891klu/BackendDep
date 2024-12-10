package com.klu.Backend;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repo extends JpaRepository<Achievements, Long> {

	List<Achievements> findByEmail(String email);
	 @Query("SELECT level, COUNT(level) FROM Achievements GROUP BY level")
	    List<Object[]> getAchievementsGroupedByLevel();
}
