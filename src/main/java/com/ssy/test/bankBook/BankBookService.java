package com.ssy.test.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO;

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		return bankBookDAO.getList();
	}
	
	public int setChangeScale (BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	public BankBookDTO getDetail (BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	}
}