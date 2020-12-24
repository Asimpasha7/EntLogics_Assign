package com.assign.assing.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class bankingdto 
{
	private long accountnumber;
	
	private double ammount;
	
	private String deposit="fhgf";
	
	private String withdraw;
}
