package ru.sbt.javaschool.ventsko.booking.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sbt.javaschool.ventsko.booking.dto.ReserveDto;
import ru.sbt.javaschool.ventsko.booking.mapes.Reserve;
import ru.sbt.javaschool.ventsko.booking.services.ResourceService;
import ru.sbt.javaschool.ventsko.booking.services.ReserveService;
import ru.sbt.javaschool.ventsko.booking.services.UserService;

import java.text.ParseException;

@Controller
public class ReservationController {

    private UserService userService;
    private ReserveService reserveService;
    private ResourceService resourceService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setReserveService(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService ){this.resourceService = resourceService ;}

    @Autowired
    private ModelMapper modelMapper;

    @Secured({"ROLE_USER"})
    @PostMapping("/resources/add")
    public String addReservedInterval(Model model, @ModelAttribute("newReserve") ReserveDto reserveDto)
            throws ParseException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        reserveDto.setUserId(userService.findByName(username).getId());

        Reserve reserve = modelMapper.map(reserveDto, Reserve.class);

        if (reserveService.validate(reserve)) {
            reserveService.add(reserve);
            model.addAttribute("reservationIsValid", true);
        } else model.addAttribute("reservationIsValid", false);

        model.addAttribute("resource", reserveDto.getServiceId());
        model.addAttribute("dateFrom", reserveDto.getDateFrom());
        model.addAttribute("dateTo", reserveDto.getDateTo());
        return "reservationResult";
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/myReservations")
    public String myReservations(Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long userID = userService.findByName(username).getId();

      /*  List<ReserveDto> reserved = reserveService.getAll()
                .stream()
                .filter(e -> e.getUserId() == userID)
                .map(e->modelMapper.map(e, ReserveDto.class))
                .forEach(e->{
                    Resource resource = resourceService.findById(e.getServiceId());

                })
                .collect(Collectors.toList());


        model.addAttribute("reserved", reserved);*/

        return "myReservations";
    }
}
