package com.springmondb.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmondb.example.models.Company;
import com.springmondb.example.repository.CompanyRepository;

@Service
public class SpringMongoServiceImpl implements SpringMongoService {
	
	@Autowired
	CompanyRepository companyRepo;

	@Override
	public Company create(Company t) {
		return companyRepo.save(t);
	}

	@Override
	public Company read(Integer id) {
		return companyRepo.findById(id);
	}

	@Override
	public Company update(Company t) {
		Company read = read(t.getId());
		if(read !=null) {
			read.setName(t.getName());
			read.setContact(t.getContact());
			read.setProducts(t.getProducts());
			return companyRepo.save(t);
		}
		return null;
	}

	@Override
	public void delete(Company t) {
		companyRepo.delete(t);
	}

	@Override
	public List<Company> create(Iterable<Company> t) {
		return companyRepo.save(t);
	}

	@Override
	public List<Company> readAll() {
		return companyRepo.findAll();
	}

	@Override
	public List<Company> getByName(String name) {
		return companyRepo.findByName(name);
	}

	@Override
	public List<Company> getByAddress(String address) {
		return companyRepo.findByAddress(address);
	}

}
