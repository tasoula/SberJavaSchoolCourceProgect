package ru.sbt.javaschool.ventsko.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;
import ru.sbt.javaschool.ventsko.booking.mapes.Resource;
import ru.sbt.javaschool.ventsko.booking.mapes.ResourceType;
import ru.sbt.javaschool.ventsko.booking.services.ResourceService;
import ru.sbt.javaschool.ventsko.booking.services.ResourceTypeService;

import java.util.List;

@Controller
public class ResourceTypeController {
    private ResourceTypeService resourceTypeService;
    private ResourceService resourceService;

    @Autowired
    public void setResourceTypeService(ResourceTypeService resourceTypeService) {
        this.resourceTypeService = resourceTypeService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("resourceTypes", resourceTypeService.getAll());
        return "resourceTypes";
    }

    @GetMapping("/{resId}")
    public String resource(Model model, @PathVariable(value="resId") long resId) {
        ResourceType resType = resourceTypeService.findById(resId);
        model.addAttribute("resourceType", StringUtils.capitalize(resType.getName()));
        List<Resource> resList = resourceService .getAllByTypeId(resId);
        model.addAttribute("resources", resList);

        return "resources";
    }
}
