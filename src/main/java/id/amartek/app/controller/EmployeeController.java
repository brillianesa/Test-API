package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Department;
import id.amartek.app.model.Employee;
import id.amartek.app.service.DepartmentServices;
import id.amartek.app.service.EmployeeServices;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices<Employee> employeeServices;

    @Autowired
    private DepartmentServices<Department> departmentServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employees", employeeServices.getAll());
        return "employee/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("employees", employeeServices.Get(id));
            model.addAttribute("departments", departmentServices.getAll());
        } else {
            model.addAttribute("employees", new Employee());
            model.addAttribute("departments", departmentServices.getAll());
        }
        return "employee/form";
    }

    @PostMapping("save")
    public String save(Employee employee) {
        Boolean isSaved = employeeServices.Save(employee);
        if (isSaved) {
            return "redirect:/employee";
        } else {
            return "employee/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = employeeServices.Delete(id);
        if (isDeleted) {
            // Data berhasil dihapus
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            // Gagal menghapus data
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/employee";
    }
}
