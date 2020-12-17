package com.ydel.shop.service.common.schemas;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="drillDownBean",propOrder={
		
		"drillDownName",
		"drillDownList"
})
public class DrillDownBean {
	
	public String drillDownName;
	
	public List drillDownList;

	public String getDrillDownName() {
		return drillDownName;
	}

	public void setDrillDownName(String drillDownName) {
		this.drillDownName = drillDownName;
	}

	public List getDrillDownList() {
		return drillDownList;
	}

	public void setDrillDownList(List drillDownList) {
		this.drillDownList = drillDownList;
	}
	

}
