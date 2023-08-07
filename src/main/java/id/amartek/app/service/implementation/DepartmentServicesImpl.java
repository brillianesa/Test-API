package id.amartek.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Department;
import id.amartek.app.repository.DepartmentRepository;
import id.amartek.app.service.DepartmentServices;

@Service
public class DepartmentServicesImpl implements DepartmentServices<Department> {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServicesImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Boolean Save(Department department) {
        try {
            departmentRepository.save(department);
            return true;
        } catch (Exception e) {
            return false;
        }
        // return departmentRepository.findById(department.getId()).isPresent();

    }

    @Override
    public Department Get(int id) {
        return departmentRepository.findById(id).orElse(null);
        // return departmentRepository.findById(id).orElseThrow() -> new
        // IllegalArgumentException("Departemen tidak ditemukan")
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            departmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // return !departmentRepository.findById(id).isPresent();

}
