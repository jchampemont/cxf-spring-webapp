package com.binarygenetics.samples.cxfspringwebapp.api;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

/**
 * Time details
 */
public class SampleTime {
	private String timezone;
	private OffsetDateTime datetime;
	private DayOfWeek dayOfWeek;

	/**
	 * Class constructor
	 */
	public SampleTime() {

	}

	/**
	 * Class constructor
	 * @param timezone Time zone
	 * @param current Current time
	 */
	public SampleTime(String timezone, OffsetDateTime datetime) {
		this.timezone = timezone;
		this.datetime = datetime;
		this.dayOfWeek = datetime.getDayOfWeek();
	}

	/**
	 * Get the time zone
	 * @return Time zone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * Get the date-time
	 * @return Date-time
	 */
	public OffsetDateTime getDateTime() {
		return datetime;
	}

	/**
	 * Get the day of the week
	 * @return Day of the week
	 */
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

}
