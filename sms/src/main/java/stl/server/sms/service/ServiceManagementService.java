package stl.server.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stl.server.sms.entity.Service;
import stl.server.sms.repository.ServiceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceManagementService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public Service createService(Service service) {
        service.setCreatedAt(LocalDateTime.now());
        service.setUpdatedAt(LocalDateTime.now());
        return serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Service updateServiceStatus(String serviceId, boolean isActive) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        service.setActive(isActive);
        service.setUpdatedAt(LocalDateTime.now());
        return serviceRepository.save(service);
    }
}
