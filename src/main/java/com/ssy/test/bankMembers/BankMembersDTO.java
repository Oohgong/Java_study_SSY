package com.ssy.test.bankMembers;

import java.util.List;

import com.ssy.test.bankAccount.BankAccountDTO;

public class BankMembersDTO {

	private String userName;
	private String password;
	private String name;
	private String Email;
	private String Phone;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTO;
	private List<RoleDTO> roleDTOs;
	
	
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}
	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	//bankAccountDTO에 넣기
//	private BankBookDto bankBookDTO;
	
	
	
	
	
}
