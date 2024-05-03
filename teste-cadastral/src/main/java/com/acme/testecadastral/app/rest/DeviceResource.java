package com.acme.testecadastral.app.rest;

import com.acme.testecadastral.app.dto.ContractDeviceRequest;
import com.acme.testecadastral.app.service.DeviceService;
import com.acme.testecadastral.cross.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("device")
@AllArgsConstructor
public class DeviceResource {

    private DeviceService deviceService;

    @PostMapping("/contracted")
    public ResponseEntity<?> contractDevice(@RequestBody ContractDeviceRequest request) throws BusinessException {
        deviceService.contractDevice(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
