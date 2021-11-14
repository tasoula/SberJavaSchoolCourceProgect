package ru.sbt.javaschool.ventsko.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.javaschool.ventsko.booking.mapes.Reserve;
import ru.sbt.javaschool.ventsko.booking.repositiries.ReserveRepository;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public Reserve add(Reserve item) throws ParseException {
        return reserveRepository.saveAndFlush(item);
    }

    public void delete(long id){
        reserveRepository.deleteById(id);
    }

    public Reserve findById(long id){
        return reserveRepository.getById(id);
    }

    public List<Reserve> getAll(){
        return reserveRepository.findAll();
    }

    public boolean validate(Reserve item){
        if(item.getDateFrom().getTime() >= item.getDateTo().getTime())
            return false;

        List<Reserve> intersections = getAll()
                .stream()
                .filter(e->e.getDateFrom().getTime() < item.getDateTo().getTime())
                .filter(e->item.getDateFrom().getTime() < e.getDateTo().getTime())
                .collect(Collectors.toList());
        return intersections.size() == 0;
    }

    //    /**
//     * Резервирование ресурса
//     * Если ресурс свободен возвращать идентификатор, если нет бросать ошибку
//     * @param user
//     * @param resource
//     * @param start
//     * @param duration
//     * @return Id ресурса (в задании Id - спецальный класс. Зачем? Пока будет long)
//     */
//    public long Acquire  (User user, Resource resource, Date start, Duration duration)throws ResourceNotFoundException {
//        return 0;
//    }

    boolean Release(long id){
        return false;
    }
}
