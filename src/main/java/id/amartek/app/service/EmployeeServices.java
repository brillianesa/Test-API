package id.amartek.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import id.amartek.app.model.Employee;
import id.amartek.app.repository.EmployeeRepository;
import id.amartek.app.service.generic.GenericServices;

public interface EmployeeServices<T> extends GenericServices<T> {
    public Integer findIdByPhoneNumber(String phonenumber);
}
