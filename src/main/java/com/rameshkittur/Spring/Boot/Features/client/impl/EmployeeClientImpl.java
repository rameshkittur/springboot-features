package com.rameshkittur.Spring.Boot.Features.client.impl;

import com.rameshkittur.Spring.Boot.Features.advices.ApiResponse;
import com.rameshkittur.Spring.Boot.Features.client.EmployeeClient;
import com.rameshkittur.Spring.Boot.Features.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try {
            ApiResponse<List<EmployeeDto>> listApiResponse = restClient.get()
                    .uri("employee")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return listApiResponse.getData();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        try {
            ApiResponse<EmployeeDto> apiResponse = restClient.get()
                    .uri("employee/{employeeId}",id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return apiResponse.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        ApiResponse<EmployeeDto> apiResponse = restClient.post()
                .uri("employee/add")
                .body(employeeDto)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        return apiResponse.getData();
    }


}
