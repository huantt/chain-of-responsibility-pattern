package com.huantt.chainofresponsibilitypattern.process

import com.huantt.chainofresponsibilitypattern.base.BaseChainProcess
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Service
class IncreaseMoneyForReceiver extends BaseChainProcess<ChainContext> {

    @Override
    RESPONSE execute() {
        context.moneyOfReceiver += context.transferMoney
        return RESPONSE.CONTINUE_PROCESSING
    }
}
