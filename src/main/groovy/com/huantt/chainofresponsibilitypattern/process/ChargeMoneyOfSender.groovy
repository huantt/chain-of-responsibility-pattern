package com.huantt.chainofresponsibilitypattern.process

import com.huantt.chainofresponsibilitypattern.base.BaseChainProcess
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Service
class ChargeMoneyOfSender extends BaseChainProcess<ChainContext> {

    @Override
    RESPONSE execute() {
        if (!context.transferMoney || context.transferMoney > context.moneyOfSender) {
            return RESPONSE.PROCESSING_COMPLETE_EARLY
        } else {
            context.moneyOfSender -= context.transferMoney
            return RESPONSE.CONTINUE_PROCESSING
        }
    }
}
