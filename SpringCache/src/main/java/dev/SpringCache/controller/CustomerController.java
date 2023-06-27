package dev.SpringCache.controller;

import dev.SpringCache.dto.CustomerDTO;
import dev.SpringCache.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> all() {
        return ResponseEntity.ok(customerService.all());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO request) {
        customerService.save(request);
        return ResponseEntity.ok().build();
    }
}
