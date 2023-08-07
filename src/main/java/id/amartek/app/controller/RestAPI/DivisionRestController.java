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

import id.amartek.app.model.Division;
import id.amartek.app.service.DivisionServices;
import id.amartek.app.handler.Response;;

@RestController
@RequestMapping("api")
public class DivisionRestController {
    @Autowired
    private DivisionServices<Division> divisionServices;

    @GetMapping("division")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", divisionServices.getAll());
    }

    @GetMapping("division/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", divisionServices.Get(id));
    }

    @PostMapping("division")
    public ResponseEntity<Object> post(@RequestBody Division division) {
        divisionServices.Save(division);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("division/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        divisionServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
