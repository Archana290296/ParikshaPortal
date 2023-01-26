package com.parikshaportal.model;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority{

	private String authorities;
	
	
	//constructor
	public Authorities(String authorities) {
		super();
		this.authorities = authorities;
	}



	@Override
	public String getAuthority() {
		
		return this.authorities;
	}

}
