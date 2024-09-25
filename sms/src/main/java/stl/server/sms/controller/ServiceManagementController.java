package stl.server.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stl.server.sms.entity.Service;
import stl.server.sms.service.ServiceManagementService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceManagementController {

    @Autowired
    private ServiceManagementService serviceManagementService;

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceManagementService.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceManagementService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{serviceId}/status")
    public ResponseEntity<Service> updateServiceStatus(@PathVariable String serviceId, @RequestParam boolean isActive) {
        Service updatedService = serviceManagementService.updateServiceStatus(serviceId, isActive);
        return ResponseEntity.ok(updatedService);
    }
}
