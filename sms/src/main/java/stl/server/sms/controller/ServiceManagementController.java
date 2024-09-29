package stl.server.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stl.server.sms.entity.ServiceEntity;  
import stl.server.sms.service.ServiceManagementService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceManagementController {

    @Autowired
    private ServiceManagementService serviceManagementService;

    @PostMapping
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity service) {  // Use ServiceEntity
        ServiceEntity createdService = serviceManagementService.createService(service);  // Use ServiceEntity
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getAllServices() {  // Use ServiceEntity
        List<ServiceEntity> services = serviceManagementService.getAllServices();  // Use ServiceEntity
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{serviceId}/status")
    public ResponseEntity<ServiceEntity> updateServiceStatus(@PathVariable String serviceId, @RequestParam boolean isActive) {  // Use ServiceEntity
        ServiceEntity updatedService = serviceManagementService.updateServiceStatus(serviceId, isActive);  // Use ServiceEntity
        return ResponseEntity.ok(updatedService);
    }
}
