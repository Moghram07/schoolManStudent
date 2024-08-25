package com.example.schoolmangexcersize.Controller;

import com.example.schoolmangexcersize.DTO.AddressDTO;
import com.example.schoolmangexcersize.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.ok("Address added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok("Address updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteAddress(@RequestBody AddressDTO addressDTO) {
        addressService.deleteAddress(addressDTO);
        return ResponseEntity.ok("Address deleted");
    }
}
