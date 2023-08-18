package id.amartek.app.service.implementation;

import id.amartek.app.model.Employee;
import id.amartek.app.repository.EmployeeRepository;
import id.amartek.app.service.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices<Employee> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Boolean Save(Employee employee) {
        try {
            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Employee Get(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer findIdByPhoneNumber(String phonenumber) {
        return employeeRepository.findIdByPhoneNumber(phonenumber);
    }

}
