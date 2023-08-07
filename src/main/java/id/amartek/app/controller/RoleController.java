package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Role;
import id.amartek.app.service.RoleServices;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleServices<Role> roleServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("roles", roleServices.getAll());
        return "role/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("roles", roleServices.Get(id));
        } else {
            model.addAttribute("roles", new Role());
        }
        return "/role/form";
    }

    @PostMapping("save")
    public String save(Role role) {
        Boolean isSaved = roleServices.Save(role);
        if (isSaved) {
            return "redirect:/role";
        } else {
            return "role/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = roleServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/role";
    }
}
