package br.com.lab.impacta.investment.domain.service.facade;

import br.com.lab.impacta.investment.domain.service.facade.vo.AccountBalanceVO;

public interface AccountFacade {
    AccountBalanceVO getAccountBalanceById(Long accountId);

    boolean debitAccount(Long accountId, Double valueOfInvestment);
}
