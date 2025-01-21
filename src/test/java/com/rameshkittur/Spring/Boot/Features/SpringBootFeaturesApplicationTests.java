package com.rameshkittur.Spring.Boot.Features;

import com.rameshkittur.Spring.Boot.Features.client.EmployeeClient;
import com.rameshkittur.Spring.Boot.Features.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringBootFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployee(){
		List<EmployeeDto>rs = employeeClient.getAllEmployee();
		System.out.println(rs);
	}

	@Test
	void getEmployeeById(){
		EmployeeDto  employeeDto = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDto);
	}

	@Test
	void addEmployee(){
		EmployeeDto request = EmployeeDto.builder()
				.age(13)
				.dateOfJoining(LocalDate.of(2024,12,12))
				.email("suresh@gmail.com")
				.name("suresh")
				.isActive(true)
				.role("ADMIN")
				.build();
		EmployeeDto employeeDto = employeeClient.addEmployee(request);
		System.out.println(employeeDto);
	}

}
