package devby.at.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import devby.at.model.Employee;
import devby.at.service.IEmployeeService;
import devby.at.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeValidator validator;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/emp_report")
	public String getEmployeeDetails(Map<String,Object> map)
	{
		List<Employee> empList=(List<Employee>) service.getEmployeeList();
		
		map.put("empList", empList);
		
		return "employee_report";
	}
	
	
	@GetMapping("/insert_employee")
	
		public String AddEmployeeForm(@ModelAttribute("emp") Employee emp)
		{
			return "add_employee";
			
		}
	
	
		@PostMapping("/insert_employee")
		public String AddEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes res, BindingResult errors) {
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);

				if (errors.hasErrors()) {
					return "add_employee";
				}
				
				if(emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN"))				
				{
					errors.rejectValue("job", "emp.job.restriction");
					return "add_employee";
				}
			}

			String result = service.addEmployee(emp);
			res.addFlashAttribute("result", result);
			return "redirect:emp_report";
		}
		
	
	@GetMapping("/edit_employee")
	public String EditEmployee(@RequestParam int eno,@ModelAttribute("emp") Employee emp)
	{
		
		Employee emp1=service.getEmployee(eno);
		BeanUtils.copyProperties(emp1, emp);
		return "modify_employee";
	}
	
	
	
	@PostMapping("/edit_employee")
	public String ModifyEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, errors);

			if (errors.hasErrors()) {
				return "modify_employee";
			}
		}

		String result = service.updateEmployee(emp) + "Emp_No Employee Updated ";
		Iterable<Employee> empList = service.getEmployeeList();
		map.put("result", result);
		map.put("empList", empList);
		return "employee_report";
	}
	
	
	@GetMapping("/delete_employee")
		public String DeleteEmployee(@RequestParam int eno,Map<String,Object> map)
		{
			String result=service.deleteEmployee(eno);
			Iterable<Employee> empList=service.getEmployeeList();
			map.put("result", result);
			map.put("empList", empList);
			return "employee_report";
		}
	
}
