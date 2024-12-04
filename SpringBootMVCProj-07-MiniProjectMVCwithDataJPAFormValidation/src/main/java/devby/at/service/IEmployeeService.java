package devby.at.service;

import devby.at.model.Employee;

public interface IEmployeeService {
public Iterable<Employee> getEmployeeList();
public String addEmployee(Employee emp);
public Employee getEmployee(int eno);
public int updateEmployee(Employee emp);
public String deleteEmployee(int eno);
}
