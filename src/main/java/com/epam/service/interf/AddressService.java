package com.epam.service.interf;

import java.util.List;

import com.epam.domain.Address;

public interface AddressService {
	List<Address> getAllAddresses();
	Long addNewAddress(Address address);
	void deleteAddress(Address address);
	void updateCAddress(Address address);
	Address getAddressById(Long id);
}
