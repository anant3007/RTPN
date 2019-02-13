package com.rtpn.gateway.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rtpn.gateway.model.AcctRef;
import com.rtpn.gateway.model.CurCode;
import com.rtpn.gateway.model.CurrAmt;
import com.rtpn.gateway.model.DebitAddOperRequest;
import com.rtpn.gateway.model.DebitAddRs;
import com.rtpn.gateway.model.DebitInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

@RestController
@RequestMapping("/api")
public class RTPNGatewayController {

	@PutMapping(value = "/rtpn/debit", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public String debit(@RequestBody DebitAddOperRequest request) {
		String responseString = "";
		
		  RestTemplate restTemplate = new RestTemplate();
			String uri = "https://firoutingmicroservice.azurewebsites.net/api/Routing";
		        HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_XML);
		        HttpEntity<String> entity = new HttpEntity<String>("<DebitAddOperRequest xmlns:xsd=\"http://www.w3.org/2001.XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
		        		"	<EFXHdr>\r\n" + 
		        		"		<Orrganization>\r\n" + 
		        		"				<OrgId>8871085</OrgId>\r\n" + 
		        		"				<Environment>ABTR</Environment>\r\n" + 
		        		"		</Orrganization>\r\n" + 
		        		"	</EFXHdr>\r\n" + 
		        		"	<DebitInfo>\r\n" + 
		        		"	<DebitType>Withdrawal</DebitType>\r\n" + 
		        		"	<EffDt></EffDt>\r\n" + 
		        		"	<PostedDt></PostedDt>\r\n" + 
		        		"	<Desc>Abc to Gene Fagg +180012831713</Desc>\r\n" + 
		        		"	<AcctRef>\r\n" + 
		        		"		<AcctId>5607314292</AcctId>\r\n" + 
		        		"		<AcctType>SDA</AcctType>\r\n" + 
		        		"		<FIIdentType>ABA</FIIdentType>\r\n" + 
		        		"		<FIIdent>325081403</FIIdent>\r\n" + 
		        		"	</AcctRef>\r\n" + 
		        		"	<CurrAmt>\r\n" + 
		        		"		<Amt>78.00</Amt>\r\n" + 
		        		"		<CurCode>\r\n" + 
		        		"			<CurCodeType>ISO4217-Alpha</CurCodeType>\r\n" + 
		        		"			<CurCodeValue>USD</CurCodeValue>\r\n" + 
		        		"		</CurCode>\r\n" + 
		        		"	</CurrAmt>\r\n" + 
		        		"	</DebitInfo>\r\n" + 
		        		"</DebitAddOperRequest>", headers);
		        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
		
		       		  responseString+=responseEntity.getBody();
		        
		/*
		 * DebitAddOperRequest daoreq= new DebitAddOperRequest();
		 * 
		 * DebitInfo di = new DebitInfo(); di.setDebitType("Withdrawal");
		 * di.setDesc("Abc to Gene Fagg +180012831713"); di.setEffDt("");
		 * di.setPostedDt("");
		 * 
		 * AcctRef ar= new AcctRef(); ar.setAcctId("5607314292"); ar.setAcctType("SDA");
		 * ar.setFIIdent("325081403"); ar.setFIIdentType("ABA");
		 * 
		 * di.setAcctRef(ar);
		 * 
		 * CurrAmt ca= new CurrAmt(); ca.setAmt("78.00");
		 * 
		 * CurCode cc= new CurCode(); cc.setCurCodeType("ISO4217-Alpha");
		 * cc.setCurCodeValue("USD");
		 * 
		 * ca.setCurCode(cc);
		 * 
		 * di.setCurrAmt(ca); daoreq.setDebitInfo(di);
		 */
		 
		  

		return responseString;
	}
}
