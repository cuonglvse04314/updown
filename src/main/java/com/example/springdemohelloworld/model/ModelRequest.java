package com.example.springdemohelloworld.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelRequest {
    private String mail;
	private String cc_number;
	private String cc_expiration;
	private String cc_owner;
	private String security_code;
	private String amount_total;
	private String ordr_tel;
	private String plan_name;
	private String ordr_kanji_sur_name;
	private String ordr_kanji_given_name;
	private String ordr_hira_sur_name;
	private String ordr_hira_given_name;
	private String ordr_tdhkn_cd;
	private String ord_addr1;
	private String ord_addr2;
}
