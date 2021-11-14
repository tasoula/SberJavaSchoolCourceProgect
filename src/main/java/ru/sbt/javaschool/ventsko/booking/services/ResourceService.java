package ru.sbt.javaschool.ventsko.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.javaschool.ventsko.booking.mapes.Resource;
import ru.sbt.javaschool.ventsko.booking.repositiries.ResourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public Resource add(Resource item){
        return resourceRepository.saveAndFlush(item);
    }

    public void delete(long id){
        resourceRepository.deleteById(id);
    }

    public Resource findById(long id){
        return resourceRepository.getById(id);
    }

    public List<Resource> getAll(){
        return resourceRepository.findAll();
    }

    public List<Resource> getAllByTypeId(long typeId){
        return  getAll().stream().filter(e->e.getType()==typeId).collect(Collectors.toList());
    }
}
