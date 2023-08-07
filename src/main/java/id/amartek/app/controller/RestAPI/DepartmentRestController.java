package id.amartek.app.controller.RestAPI;

import java.util.List;

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

import id.amartek.app.model.Department;
import id.amartek.app.service.DepartmentServices;
import id.amartek.app.handler.Response;;

@RestController
@RequestMapping("api")
public class DepartmentRestController {
    @Autowired
    private DepartmentServices<Department> departmentServices;

    @GetMapping("department")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", departmentServices.getAll());
    }

    @GetMapping("department/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", departmentServices.Get(id));
    }

    @PostMapping("department")
    public ResponseEntity<Object> post(@RequestBody Department department) {
        departmentServices.Save(department);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("department/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        departmentServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
