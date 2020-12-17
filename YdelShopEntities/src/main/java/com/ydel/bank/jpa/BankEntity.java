package com.ydel.bank.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bank database table.
 * 
 */
@Entity
@Table(name="bank",schema="ydel")

@TableGenerator(catalog="ydel",name="bankTableGenerator",initialValue=1,allocationSize=1)
@NamedQueries({
@NamedQuery(name="BankEntity.findAll", query="SELECT b FROM BankEntity b"),
@NamedQuery(name="BankEntity.findBYCode", query="SELECT b FROM BankEntity b")
})
public class BankEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
@GeneratedValue(strategy=GenerationType.TABLE,generator="bankTableGenerator")
	@Id
	@Column(name="bank_id")
	private int bankId;

	@Column(name="bank_address")
	private String bankAddress;

	
	@Column(name="bank_code")
	private String bankCode;

	@Column(name="bank_name")
	private String bankName;

	
	public BankEntity() {
	}


	public int getBankId() {
		return bankId;
	}


	public void setBankId(int bankId) {
		this.bankId = bankId;
	}


	public String getBankAddress() {
		return bankAddress;
	}


	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}


	public String getBankCode() {
		return bankCode;
	}


	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}