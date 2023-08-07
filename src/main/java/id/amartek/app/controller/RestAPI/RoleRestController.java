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

import id.amartek.app.model.Role;
import id.amartek.app.service.RoleServices;
import id.amartek.app.handler.Response;

@RestController
@RequestMapping("api")
public class RoleRestController {
    @Autowired
    private RoleServices<Role> roleServices;

    @GetMapping("role")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", roleServices.getAll());
    }

    @GetMapping("role/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", roleServices.Get(id));
    }

    @PostMapping("role")
    public ResponseEntity<Object> post(@RequestBody Role role) {
        roleServices.Save(role);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("role/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        roleServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
