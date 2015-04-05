package com.epam.repository.interf;

import java.util.List;

import com.epam.domain.Address;

public interface AddressRepository {
	Long create(Address address);
	Address read(Long id);
	void update(Address address);
	void delete(Address address);
	List<Address> getAllAddresses();
}
