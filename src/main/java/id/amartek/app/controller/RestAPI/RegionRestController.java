package id.amartek.app.controller.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.model.Region;
import id.amartek.app.service.RegionServices;
import id.amartek.app.handler.Response;;

@CrossOrigin
@RestController
@RequestMapping("api")
public class RegionRestController {
    @Autowired
    private RegionServices<Region> regionServices;

    @GetMapping("region")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", regionServices.getAll());
    }

    @GetMapping("region/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", regionServices.Get(id));
    }

    @PostMapping("region")
    public ResponseEntity<Object> post(@RequestBody Region region) {
        regionServices.Save(region);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("region/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        regionServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }

}
