package com.acme.testecadastral.app.service;

import com.acme.testecadastral.app.dto.ContractDeviceRequest;
import com.acme.testecadastral.cross.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class DeviceService {

    private static final String DEVICE_BROKEN = "device broken";
    private static final String DEVICE_NOT_CONTRACTED_LOG_MSG = "Device not contracted |";

    public void contractDevice(ContractDeviceRequest request) throws BusinessException {

        if(Objects.isNull(request.getDevice()) || request.getDevice().isEmpty() ||
                request.getDevice().isBlank()) {
            log.info(DEVICE_NOT_CONTRACTED_LOG_MSG + " 400 | "+  request.getDevice());
            throw new BusinessException(request.getDevice());
        }

        if(DEVICE_BROKEN.equals(request.getDevice())) {
            log.info(DEVICE_NOT_CONTRACTED_LOG_MSG + " 500 | " + request.getDevice());
            throw new RuntimeException(request.getDevice());
        }

        log.info("Device contracted: " + request.getDevice());
    }
}
