package com.binarygenetics.samples.cxfspringwebapp.impl;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.binarygenetics.samples.cxfspringwebapp.api.SampleException;
import com.binarygenetics.samples.cxfspringwebapp.api.SampleTime;
import com.binarygenetics.samples.cxfspringwebapp.api.SampleTimeServices;

/**
 * Sample time services implementation
 */
@Service
public class SampleTimeServicesImpl implements SampleTimeServices {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleTimeServicesImpl.class);

	@Override
	public SampleTime getTime() throws SampleException {
		LOGGER.info("Requested /sample/time");
		return new SampleTime(ZoneId.systemDefault().getId(), OffsetDateTime.now());
	}

	@Override
	public SampleTime getError() throws SampleException {
		LOGGER.info("Requested /sample/time/error");
		throw new SampleException("get time error");
	}

}
