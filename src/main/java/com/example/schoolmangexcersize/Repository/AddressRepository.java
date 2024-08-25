package com.example.schoolmangexcersize.Repository;

import com.example.schoolmangexcersize.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);
}
