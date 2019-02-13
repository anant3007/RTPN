package com.rtpn.gateway.model;

import javax.xml.bind.annotation.XmlElement;

public class EFXHdr {
     @XmlElement
	 private Orrganization Orrganization;

	    public Orrganization getOrrganization ()
	    {
	        return Orrganization;
	    }

	    public void setOrrganization (Orrganization Orrganization)
	    {
	        this.Orrganization = Orrganization;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Orrganization = "+Orrganization+"]";
	    }
}
