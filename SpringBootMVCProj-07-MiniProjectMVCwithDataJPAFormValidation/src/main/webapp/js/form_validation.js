function Validate(frm) {
	
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptErr").innerHTML="";
	
	
	let name = frm.ename.value;
	let job = frm.job.value;
	let salary = frm.sal.value;
	let dept = frm.deptno.value
	let validation_flag=true;

	if (name == "")
		{
		document.getElementById("enameErr").innerHTML = "Employee Name is Required(CS)";
		validation_flag=false;
		}
	else if (name.length() < 5)
		{
		document.getElementById("enameErr").innerHTML = "Employee Name must have minimum 5 char(CS)";
		validation_flag=false;
				}

	if (job == "")
		{
		document.getElementById("jobErr").innerHTML = "Employee DESG is Required(CS)";
		validation_flag=false;
				}
	else if (job.length() < 5)
		{
		document.getElementById("jobErr").innerHTML = "Employee DESG must have minimum 5 char(CS)";
		validation_flag=false;
				}

	if (salary =="")
		{
		document.getElementById("salErr").innerHTML = "Employee Salary is Required(CS)";
		validation_flag=false;
				}
	else if (salary < 1000)
		{
		document.getElementById("salErr").innerHTML = "Employee Salary must  be greater than 1000(CS)";
		validation_flag=false;
				}
	else if (isNaN(salary))
		{
		document.getElementById("salErr").innerHTML = "Salary Must be A numeric value(CS)"
		validation_flag=false;
				}


	if (dept == "")
		{
		document.getElementById("deptErr").innerHTML = "Employee Salary is Required(CS)";
		validation_flag=false;
				}
	else if (dept < 1)
		{
		document.getElementById("deptErr").innerHTML = "Employee DEpartment must be greater than 1(CS)";
		validation_flag=false;
				}
	else if (isNaN(dept))
		{
		document.getElementById("deptErr").innerHTML = "DEPT NO Must be A numeric value(CS)"
		validation_flag=false;
				}
				
				return validation_flag;
	

}