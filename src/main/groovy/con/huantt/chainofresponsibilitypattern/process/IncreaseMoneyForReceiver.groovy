package con.huantt.chainofresponsibilitypattern.process

import con.huantt.chainofresponsibilitypattern.base.BaseChainProcess
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Service
class IncreaseMoneyForReceiver extends BaseChainProcess<ChainContext> {

    @Override
    boolean execute() {
        context.moneyOfReceiver += context.transferMoney
        return CONTINUE_PROCESSING
    }
}
