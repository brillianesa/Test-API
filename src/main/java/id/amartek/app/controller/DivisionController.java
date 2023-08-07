package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Department;
import id.amartek.app.model.Division;
import id.amartek.app.repository.DivisionRepository;
import id.amartek.app.service.DivisionServices;

@Controller
@RequestMapping("division")
public class DivisionController {
    @Autowired
    DivisionServices<Division> divisionServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("divisions", divisionServices.getAll());
        return "division/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {

            model.addAttribute("divisions", divisionServices.Get(id));

        } else {

            model.addAttribute("divisions", new Division());

        }
        return "division/form";
    }

    @PostMapping("save")
    public String save(Division division) {
        Boolean isSaved = divisionServices.Save(division);
        if (isSaved) {
            return "redirect:/division";
        } else {
            return "division/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = divisionServices.Delete(id);
        if (isDeleted) {
            // Data berhasil dihapus
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            // Gagal menghapus data
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/division";
    }
}
