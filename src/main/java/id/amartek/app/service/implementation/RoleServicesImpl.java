package id.amartek.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Role;
import id.amartek.app.repository.RoleRepository;
import id.amartek.app.service.RoleServices;

@Service
public class RoleServicesImpl implements RoleServices<Role> {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServicesImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Boolean Save(Role role) {
        try {
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Role Get(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
