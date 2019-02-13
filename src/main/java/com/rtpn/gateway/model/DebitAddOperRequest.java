package com.rtpn.gateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitAddOperRequest {

	@XmlElement
	private DebitInfo DebitInfo;

	@XmlElement
    private EFXHdr EFXHdr;

    public DebitInfo getDebitInfo ()
    {
        return DebitInfo;
    }

    public void setDebitInfo (DebitInfo DebitInfo)
    {
        this.DebitInfo = DebitInfo;
    }

    public EFXHdr getEFXHdr ()
    {
        return EFXHdr;
    }

    public void setEFXHdr (EFXHdr EFXHdr)
    {
        this.EFXHdr = EFXHdr;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DebitInfo = "+DebitInfo+", EFXHdr = "+EFXHdr+"]";
    }
}
