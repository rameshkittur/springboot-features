package com.rameshkittur.Spring.Boot.Features.client.impl;

import com.rameshkittur.Spring.Boot.Features.advices.ApiResponse;
import com.rameshkittur.Spring.Boot.Features.client.EmployeeClient;
import com.rameshkittur.Spring.Boot.Features.dto.EmployeeDto;
import com.rameshkittur.Spring.Boot.Features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

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
        log.info("Adding New Employee from addEmployee");
        try {
            log.info("Making rest client call ");
            ApiResponse<EmployeeDto> apiResponse = restClient.post()
                    .uri("employee/add")
                    .body(employeeDto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not proceed because of unavailable resource ");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.info("Successfully added the employee");
            return apiResponse.getData();
        } catch (Exception e) {
            log.error("Error occurred while addEmployee :",e);
            throw new RuntimeException(e);
        }

    }


}
