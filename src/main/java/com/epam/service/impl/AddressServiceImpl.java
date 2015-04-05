package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.domain.Address;
import com.epam.repository.interf.AddressRepository;
import com.epam.service.interf.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public AddressServiceImpl() {
	}

	public List<Address> getAllAddresses() {
		return addressRepository.getAllAddresses();
	}

	public Long addNewAddress(Address address) {
		return addressRepository.create(address);
	}

	public void deleteAddress(Address address) {
		addressRepository.delete(address);
	}

	public void updateCAddress(Address address) {
		addressRepository.update(address);
	}

	public Address getAddressById(Long id) {
		return addressRepository.read(id);
	}

}
