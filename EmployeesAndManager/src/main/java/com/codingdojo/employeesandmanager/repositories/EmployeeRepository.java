package com.codingdojo.employeesandmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.employeesandmanager.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Query("SELECT e FROM Employee e WHERE e.manager=null")
	List<Employee> findManagers();
}
