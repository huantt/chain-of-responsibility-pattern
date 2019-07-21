package con.huantt.chainofresponsibilitypattern.process

import con.huantt.chainofresponsibilitypattern.base.BaseChainProcess
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Service
class ChargeMoneyOfSender extends BaseChainProcess<ChainContext> {

    @Override
    boolean execute() {
        if (!context.transferMoney || context.transferMoney > context.moneyOfSender) {
            return PROCESSING_COMPLETE
        } else {
            context.moneyOfSender -= context.transferMoney
            return CONTINUE_PROCESSING
        }
    }
}
