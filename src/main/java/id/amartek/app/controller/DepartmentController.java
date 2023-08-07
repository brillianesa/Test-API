package id.amartek.app.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.amartek.app.model.Department;
import id.amartek.app.model.Division;
import id.amartek.app.model.Region;
import id.amartek.app.repository.DepartmentRepository;
import id.amartek.app.service.DepartmentServices;
import id.amartek.app.service.DivisionServices;
import id.amartek.app.service.RegionServices;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentServices<Department> departmentServices;

    @Autowired
    private RegionServices<Region> regionServices;

    @Autowired
    private DivisionServices<Division> divisionServices;

    @GetMapping()
    public String index(Model model) {
        // url = localhost:8088/department
        // departmentServices.getAll();
        // List<Department> department = departmentServices.getAll();
        model.addAttribute("departments", departmentServices.getAll());
        return "department/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("regions", regionServices.getAll());
            model.addAttribute("divisions", divisionServices.getAll());
            model.addAttribute("departments", departmentServices.Get(id));
        } else {
            model.addAttribute("regions", regionServices.getAll());
            model.addAttribute("divisions", divisionServices.getAll());
            model.addAttribute("departments", new Department());
        }
        return "department/form";
    }

    @PostMapping("save")
    public String save(Department department) {
        Boolean isSaved = departmentServices.Save(department);
        if (isSaved) {
            return "redirect:/department";
        } else {
            return "department/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = departmentServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/department";
    }

}
