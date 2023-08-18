package id.amartek.app.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import id.amartek.app.DTO.RegisterRequest;
import id.amartek.app.model.Employee;
import id.amartek.app.model.User;
import id.amartek.app.service.AccountService;
import id.amartek.app.service.EmployeeServices;
import id.amartek.app.service.UserServices;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserServices<User> userServices;

    @Autowired
    private EmployeeServices<Employee> employeeServices;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        Employee emp = new Employee();
        User user = new User();
        emp.setFullName(registerRequest.getName());
        emp.setNumberPhone(registerRequest.getPhonenumber());
        Boolean empSave = employeeServices.Save(emp);
        if (empSave) {
            Integer employee_id = employeeServices.findIdByPhoneNumber(registerRequest.getPhonenumber());
            user.setId(employee_id);
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            Boolean userSave = userServices.Save(user);
            return userSave;
        }
        return empSave;

    }

}
