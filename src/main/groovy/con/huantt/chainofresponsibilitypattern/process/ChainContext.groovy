package con.huantt.chainofresponsibilitypattern.process

import con.huantt.chainofresponsibilitypattern.base.BaseChainContext
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Component
class ChainContext implements BaseChainContext{

    double transferMoney
    double moneyOfReceiver
    double moneyOfSender

    @Override
    void refreshData() {
        //Refresh data from database
    }
}
