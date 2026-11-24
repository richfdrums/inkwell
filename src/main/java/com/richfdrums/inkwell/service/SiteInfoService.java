package com.richfdrums.inkwell.service;

import com.richfdrums.inkwell.config.InkwellProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SiteInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SiteInfoService.class);

    private final InkwellProperties properties;

    public SiteInfoService(InkwellProperties properties) {
        this.properties = properties;

        LOGGER.debug("Inkwell settings: [{}]", properties);
    }
}
