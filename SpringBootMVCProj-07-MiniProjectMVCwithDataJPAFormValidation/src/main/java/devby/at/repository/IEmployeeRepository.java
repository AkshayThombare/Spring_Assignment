package devby.at.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import devby.at.model.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer>,CrudRepository<Employee, Integer>{

}
