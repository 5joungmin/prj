package com.wa.erp;

import java.util.Map;

public interface MemberService {
	
	public int insertMemberCnt( MemberDTO memberDTO);
	
	/*--------------회사 정보를 위한 선언-------------*/
	public int insertCompany(MemberDTO companyDTO);

	public int insertCompanyInfo(MemberDTO companyDTO);
	/*-------------------------------------------*/
	}
