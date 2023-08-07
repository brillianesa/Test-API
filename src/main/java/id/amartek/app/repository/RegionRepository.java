package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

}
