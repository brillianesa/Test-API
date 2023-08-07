package id.amartek.app.controller.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.model.Employee;
import id.amartek.app.service.EmployeeServices;
import id.amartek.app.handler.Response;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    @Autowired
    private EmployeeServices<Employee> employeeServices;

    @GetMapping("employee")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", employeeServices.getAll());
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", employeeServices.Get(id));
    }

    @PostMapping("employee")
    public ResponseEntity<Object> post(@RequestBody Employee employee) {
        employeeServices.Save(employee);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        employeeServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
