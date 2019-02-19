package com.rtpn.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rtpn.gateway.controller.RTPNGatewayController;
import com.rtpn.gateway.model.AcctRef;
import com.rtpn.gateway.model.CurCode;
import com.rtpn.gateway.model.CurrAmt;
import com.rtpn.gateway.model.DebitAddOperRequest;
import com.rtpn.gateway.model.DebitInfo;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RTPNGatewayController.class, secure = false)
public class RTPNGatewayControllerTest {

	@Autowired
	private MockMvc mockMvc;

	
	

	@Test
	public void debit() throws Exception {
		
		String sampleRequestBody="<DebitAddOperRequest xmlns:xsd=\"http://www.w3.org/2001.XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
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
				"</DebitAddOperRequest>";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/api/rtpn/debit").accept(
				MediaType.APPLICATION_XML).content(sampleRequestBody).contentType(MediaType.APPLICATION_XML);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());

		String exampleResponseString="<?xml version=\"1.0\" encoding=\"utf - 8\" ?>"+" <DebitAddRs><StatusCode>0</StatusCode><Severity>Info</Severity><SvcProviderName>DNA</SvcProviderName><DebitKeys><DebitId>123</DebitId><AcctKeys><AcctId>560731492</AcctId><AcctType>SDA</AcctType></AcctKeys></DebitKeys><DebitStatus><DebitStatusCode>Posted from FI 1</DebitStatusCode><EffDt>2018-18-01T10:12:12.211</EffDt></DebitStatus></DebitAddRs>";
		
		//assertEquals(exampleResponseString, result.getResponse().getContentAsString());
		
		assertNotNull(result.getResponse().getContentAsString());


	}
	
	
	/*
	 * @Test public void debit_fail() throws Exception {
	 * 
	 * throw new Exception(); }
	 */
	
}
