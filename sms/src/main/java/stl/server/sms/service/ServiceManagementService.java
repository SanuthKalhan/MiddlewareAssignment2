package stl.server.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stl.server.sms.entity.ServiceEntity; 
import stl.server.sms.repo.ServiceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceManagementService {

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceEntity createService(ServiceEntity service) {
        service.setCreatedAt(LocalDateTime.now());
        service.setUpdatedAt(LocalDateTime.now());
        return serviceRepository.save(service);
    }

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity updateServiceStatus(String serviceId, boolean isActive) {
        ServiceEntity service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        service.setActive(isActive);
        service.setUpdatedAt(LocalDateTime.now());
        return serviceRepository.save(service);
    }
}
