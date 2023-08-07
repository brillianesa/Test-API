package id.amartek.app.service.implementation;

import id.amartek.app.model.Division;
import id.amartek.app.repository.DivisionRepository;
import id.amartek.app.service.DivisionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServicesImpl implements DivisionServices<Division> {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionServicesImpl(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public Boolean Save(Division division) {
        try {
            divisionRepository.save(division);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Division Get(int id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Division> getAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            divisionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
