package com.example.restservice;

import com.example.restservice.common.CustomError;
import com.example.restservice.employee.Employee;
import com.example.restservice.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {
	public static final String DIGITS = "\\d+";
	private final EmployeeService employeeService;


	private final String  message1;
	private final String  message2;
	public EmployeeController(EmployeeService employeeService,
							  @Value("${message1}") String message1,
							  @Value("${message2}") String message2) {
		this.employeeService = employeeService;
		this.message1 = message1;
		this.message2 = message2;
	}

	@PostMapping("/employee")
	public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) throws CustomError {
		return employeeService.save(employeeDto);
	}

	@GetMapping("/employee/{age}")
	public List<Employee> getEmployees(@PathVariable("age") Integer age) throws CustomError {
		return employeeService.getAllWithAge(age);
	}

	@GetMapping("/message")
	public List<String> message() throws CustomError {
		return List.of(message1,message2);
	}

	@GetMapping("/hello/{name}")
	public ResponseEntity<String> hello(@PathVariable("name") String name) throws CustomError {
		if(name.matches(DIGITS)){
			return ResponseEntity.badRequest().body("Invalid name");
		}
		return ResponseEntity.ok("Hello "+name);
	}
}
