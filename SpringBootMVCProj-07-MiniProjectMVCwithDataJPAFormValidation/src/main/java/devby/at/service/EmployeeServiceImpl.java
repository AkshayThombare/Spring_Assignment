package devby.at.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import devby.at.model.Employee;
import devby.at.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
@Autowired
private IEmployeeRepository repository;
	
@Override
	public Iterable<Employee> getEmployeeList() {
		Iterable<Employee> empList=repository.findAll(Sort.by("job").ascending());
		return empList;
	}

@Override
public int updateEmployee(Employee emp) {
	return repository.save(emp).getEno();
	
}

@Override
public String deleteEmployee(int eno) {
	repository.deleteById(eno);
	return "Record is deleted with Emp no:"+eno;
	
}

@Override
public String addEmployee(Employee emp) {
	int eno=repository.save(emp).getEno();
	return "Employee inserted with "+ eno;
}

@Override
public Employee getEmployee(int eno) {
	return repository.findById(eno).get();
}



}
