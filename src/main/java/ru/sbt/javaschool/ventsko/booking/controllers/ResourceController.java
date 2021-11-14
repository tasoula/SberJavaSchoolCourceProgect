package ru.sbt.javaschool.ventsko.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.sbt.javaschool.ventsko.booking.mapes.Resource;
import ru.sbt.javaschool.ventsko.booking.mapes.Reserve;
import ru.sbt.javaschool.ventsko.booking.services.ResourceService;
import ru.sbt.javaschool.ventsko.booking.services.ReserveService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ResourceController {
    private ResourceService resourceService;
    private ReserveService reserveService;

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Autowired
    public void setReserveService(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @GetMapping("/resource")
    public String showResources(Model model) {
        model.addAttribute("resources", resourceService.getAll());
        return "resources";
    }

    @GetMapping("/resources/{serviceURI}")
    public String resource(Model model, @PathVariable(value="serviceURI") long serviceId) {
        Resource resource = resourceService.findById(serviceId);
        model.addAttribute("resource", resource);

        List<Reserve> reserved = reserveService.getAll().stream().filter(e -> e.getServiceId() == serviceId).collect(Collectors.toList());
        model.addAttribute("reserved", reserved);

        Reserve newReserve = new Reserve();
        newReserve.setServiceId(serviceId);
        model.addAttribute("newReserve", newReserve);

        return "resource";
    }


}
