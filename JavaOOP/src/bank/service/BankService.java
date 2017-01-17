package bank.service;

import java.util.HashMap;

import bank.dao.BankDAO;
import bank.dto.BankDTO;

public class BankService {

	public BankDTO deposit(BankDTO dto) {
        // 로직처리를 해요.
		// DB처리를 해요.
		BankDAO dao = new BankDAO();
		
		BankDTO result = dao.select(dto);
		
		if( result != null ) {
			dto = dao.updateDeposit(dto);
		}
		return dto;
	}

	public BankDTO withdraw(BankDTO dto) {
		BankDAO dao = new BankDAO();
		
		BankDTO result = dao.select(dto);
		
		if( (result != null) && (result.getBalance() >= dto.getBalance()) ) {
			dto = dao.updateWithdraw(dto);
		}
		return dto;
	}

	public HashMap<String, BankDTO> transfer(BankDTO depositDto, BankDTO withdrawDto) {
		HashMap<String, BankDTO> result = 
				new HashMap<String, BankDTO>();
		result.put("deposit",deposit(depositDto));
		result.put("withdraw",withdraw(withdrawDto));
		return result;
	}
}






