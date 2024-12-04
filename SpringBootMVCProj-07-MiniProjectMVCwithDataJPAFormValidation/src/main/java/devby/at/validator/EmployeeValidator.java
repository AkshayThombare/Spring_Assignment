package devby.at.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import devby.at.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println("Support Method");
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Validator method");
		Employee emp = (Employee) target;

		if (emp.getEname() == null || emp.getEname().isBlank())
			errors.rejectValue("ename", "emp.ename.required");
		else if (emp.getEname().length() < 5)
			errors.rejectValue("ename", "emp.ename.minlength");

		if (emp.getJob() == null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<4)
			errors.rejectValue("job","emp.job.minlength");
		
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal()<1000)
			errors.rejectValue("sal", "emp.sal.minlength");
		
		
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(emp.getDeptno()<1)
			errors.rejectValue("deptno", "emp.deptno.minlength");
	}

}
