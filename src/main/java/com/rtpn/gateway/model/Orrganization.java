package com.rtpn.gateway.model;

import javax.xml.bind.annotation.XmlElement;

public class Orrganization {

	@XmlElement
	 private String OrgId;
        @XmlElement
	    private String Environment;

	    public String getOrgId ()
	    {
	        return OrgId;
	    }

	    public void setOrgId (String OrgId)
	    {
	        this.OrgId = OrgId;
	    }

	    public String getEnvironment ()
	    {
	        return Environment;
	    }

	    public void setEnvironment (String Environment)
	    {
	        this.Environment = Environment;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [OrgId = "+OrgId+", Environment = "+Environment+"]";
	    }
}
