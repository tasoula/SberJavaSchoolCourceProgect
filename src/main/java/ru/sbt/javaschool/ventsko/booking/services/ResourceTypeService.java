package ru.sbt.javaschool.ventsko.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.javaschool.ventsko.booking.mapes.ResourceType;
import ru.sbt.javaschool.ventsko.booking.repositiries.ResourceTypeRepository;

import java.util.List;

@Service
public class ResourceTypeService {
    @Autowired
    private ResourceTypeRepository resourceTypeRepository;

    public ResourceType add(ResourceType item){
        return resourceTypeRepository.saveAndFlush(item);
    }

    public void delete(long id){
        resourceTypeRepository.deleteById(id);
    }

    public ResourceType findById(long id){
        return resourceTypeRepository.getById(id);
    }

    public List<ResourceType> getAll(){
        return resourceTypeRepository.findAll();
    }
}
