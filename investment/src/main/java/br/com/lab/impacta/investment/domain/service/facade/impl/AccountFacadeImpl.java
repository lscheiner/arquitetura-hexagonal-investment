package br.com.lab.impacta.investment.domain.service.facade.impl;

import org.springframework.stereotype.Component;

import br.com.lab.impacta.investment.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.investment.domain.service.facade.AccountFacade;
import br.com.lab.impacta.investment.domain.service.facade.vo.AccountBalanceVO;
import br.com.lab.impacta.investment.domain.service.facade.vo.DebitAccountVO;
import br.com.lab.impacta.investment.infrastructure.http.AccountClient;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountFacadeImpl implements AccountFacade {
    
    private AccountClient accountClient;

    @Override
    public AccountBalanceVO getAccountBalanceById(Long accountId) {
        return this.accountClient.getAccountBalance(accountId);
    }

    @Override
    public boolean debitAccount(Long accountId, Double valueOfInvestment) {
        DebitAccountVO debitAccountVO = this.accountClient.debit(accountId,
                new DebitAccountRequest(valueOfInvestment));

        return debitAccountVO.isDebited();
    }
}
