package ressources;

import java.util.ArrayList;
import java.util.List;


import entities.Employee;

public class EmployeeApi {
	static List<Employee> list = new ArrayList<Employee>();
	public EmployeeApi() {
		// TODO Auto-generated constructor stub
		this.list.add(new Employee("0000", "Ali", "Ben ahmed"));
	}
	
	public List getEmployee() {
		return this.list;
	}
	
	public String addEmployee(Employee employee) {
		this.list.add(employee);
		return "Employee addedsuccessful";
	}
	
	public String updateEmploye(Employee e) {
		int index = getIndexByCin(e.getCin());

		if (index != -1) {
			list.set(index, e);
			return "update successful";
		}
		return "update unsuccessful";
	}

	public String deleteEmploye(String cin) {
		int index = getIndexByCin(cin);
		if (index != -1) {
			this.list.remove(index);
			return "true";
		} else
			return "false";
	}

	public int getIndexByCin(String cin) {
		for (Employee emp : this.list) {
			if (emp.getCin().equals(cin))
				return this.list.indexOf(emp);
		}
		return -1;
	}


}
