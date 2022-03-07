package br.com.lab.impacta.investment.domain.service.impl;

import org.springframework.stereotype.Service;

import br.com.lab.impacta.investment.domain.exception.InvestmentAccountIsNotDebitException;
import br.com.lab.impacta.investment.domain.exception.InvestmentAccountWithoutBalanceException;
import br.com.lab.impacta.investment.domain.exception.InvestmentAccountWithoutBalanceForProductPrivateException;
import br.com.lab.impacta.investment.domain.exception.InvestmentProductNotFoundException;
import br.com.lab.impacta.investment.domain.model.Investment;
import br.com.lab.impacta.investment.domain.model.Product;
import br.com.lab.impacta.investment.domain.service.InvestmentService;
import br.com.lab.impacta.investment.domain.service.facade.AccountFacade;
import br.com.lab.impacta.investment.domain.service.facade.valueObject.AccountBalanceVO;
import br.com.lab.impacta.investment.infrastructure.message.MessageService;
import br.com.lab.impacta.investment.infrastructure.repository.InvestmentRepository;
import br.com.lab.impacta.investment.infrastructure.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {

    private InvestmentRepository investmentRepository;

    private ProductRepository productRepository;

    private AccountFacade accountFacade;
    
    private MessageService messageService;

    @Override
    public Investment invest(Long productId, Long accountId, Double valueInvestment) {
        
    	Product product = this.productRepository.findById(productId)
        		.orElseThrow(() -> new InvestmentProductNotFoundException(
        		this.messageService.getMessage("lab.investment.exceptions.product-dont-exists-message"),
        		this.messageService.getMessage("lab.investment.exceptions.product-dont-exists-description")));


        Investment investment = new Investment(productId, accountId, valueInvestment);

        AccountBalanceVO accountBalanceVO = this.accountFacade.getAccountBalanceById(accountId);

        this.sufficientBalanceForInvestment(accountBalanceVO, investment);

        this.verifyProductPrivateOrDefaultForInvestment(product, investment, accountBalanceVO);

        this.isDebited(this.accountFacade.debitAccount(accountId, valueInvestment));

        this.investmentRepository.save(investment);

        return investment;
    }

    
    private void sufficientBalanceForInvestment(AccountBalanceVO accountBalanceVO , Investment investment) {
    	
    	if (!investment.sufficientBalanceForInvestment(accountBalanceVO.getBalance()))
            throw new InvestmentAccountWithoutBalanceException(
            		this.messageService.getMessage("lab.investment.exceptions.account-without-balance-message"),
            		this.messageService.getMessage("lab.investment.exceptions.account-without-balance-description"));
    }
    
	private void verifyProductPrivateOrDefaultForInvestment(Product product, Investment investment, AccountBalanceVO accountBalanceVO) {
		
		if (!investment.verifyProductPrivateOrDefaultForInvestment(accountBalanceVO.getBalance(), product))
            throw new InvestmentAccountWithoutBalanceForProductPrivateException(
            		this.messageService.getMessage("lab.investment.exceptions.account-without-balance-for-product-private-message"),
            		this.messageService.getMessage("lab.investment.exceptions.account-without-balance-for-product-private-description"));
	}
	
	private void isDebited(boolean isDebited) {
		if (!isDebited)
            throw new InvestmentAccountIsNotDebitException(
            		this.messageService.getMessage("lab.investment.exceptions.account-is-not-debited-message"),
            		this.messageService.getMessage("lab.investment.exceptions.account-is-not-debited-description"));
	}
    
}
