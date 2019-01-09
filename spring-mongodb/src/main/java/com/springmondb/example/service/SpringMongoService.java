package com.springmondb.example.service;

import java.util.List;

import com.springmondb.example.models.Company;

public interface SpringMongoService extends GenericService<Company, Integer>{

	List<Company> getByName(String string);

	List<Company> getByAddress(String string);

}
