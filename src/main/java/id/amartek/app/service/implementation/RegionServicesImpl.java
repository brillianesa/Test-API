package id.amartek.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Region;
import id.amartek.app.repository.RegionRepository;
import id.amartek.app.service.RegionServices;

@Service
public class RegionServicesImpl implements RegionServices<Region> {
    private final RegionRepository regionRepository;

    @Autowired
    public RegionServicesImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Boolean Save(Region region) {
        try {
            regionRepository.save(region);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Region Get(int id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            regionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
