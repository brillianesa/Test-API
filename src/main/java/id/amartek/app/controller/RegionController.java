package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Region;
import id.amartek.app.service.RegionServices;

@Controller
@RequestMapping("region")
public class RegionController {
    @Autowired
    private RegionServices<Region> regionServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("regions", regionServices.getAll());
        return "region/index";

    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("regions", regionServices.Get(id));
        } else {
            model.addAttribute("regions", new Region());
        }
        return "/region/form";
    }

    @PostMapping("save")
    public String save(Region region) {
        Boolean isSaved = regionServices.Save(region);
        if (isSaved) {
            return "redirect:/region";
        } else {
            return "region/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = regionServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/region";
    }
}
