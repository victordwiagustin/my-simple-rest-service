package com.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.model.SampleModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neviim 2 on 19/11/2017.
 */

@RestController
public class SampleController {

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping()
    public ResponseEntity<Map<String, Object>> doAdd(@RequestBody Map<String, Object> request){
        HttpStatus httpStatus;
        Map<String, Object> responseResult = new HashMap<>();

        SampleModel sampleModel = objectMapper.convertValue(request.get("add"), SampleModel.class);

        System.out.println("<<<POST DATA>>>\n" + request + "\n<<<END OF POST DATA>>>\n");
        System.out.println("<<<To Model>>>\n" + "Nama = " + sampleModel.getName() + "\nAlamat = " + sampleModel.getAddress() + "\n<<<END OF To Model>>>\n");

        httpStatus = HttpStatus.OK;
        responseResult.put("result", Boolean.TRUE);

        return new ResponseEntity<>(responseResult, httpStatus);
    }
}
