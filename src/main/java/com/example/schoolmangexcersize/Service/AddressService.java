package com.example.schoolmangexcersize.Service;

import com.example.schoolmangexcersize.ApiResponse.ApiResponse;
import com.example.schoolmangexcersize.DTO.AddressDTO;
import com.example.schoolmangexcersize.Model.Address;
import com.example.schoolmangexcersize.Model.Teacher;
import com.example.schoolmangexcersize.Repository.AddressRepository;
import com.example.schoolmangexcersize.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(t == null) {
            throw new ApiResponse("Teacher not found");
        }
        Address address = new Address(t.getId(), addressDTO.getState(), addressDTO.getCity(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), t);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address a = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(a == null) {
            throw new ApiResponse("Address not found");
        }
        a.setState(addressDTO.getState());
        a.setCity(addressDTO.getCity());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(a);
    }

    public void deleteAddress(AddressDTO addressDTO) {
        Address a = addressRepository.findAddressById(addressDTO.getId());
        if(a == null) {
            throw new ApiResponse("Address not found");
        }
        addressRepository.delete(a);
    }
}
