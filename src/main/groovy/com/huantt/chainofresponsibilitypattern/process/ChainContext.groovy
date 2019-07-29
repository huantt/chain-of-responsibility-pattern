package com.huantt.chainofresponsibilitypattern.process


import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Component
class ChainContext implements com.huantt.chainofresponsibilitypattern.base.BaseChainContext {

    String senderCardNumber
    String receiverCardNumber

    double transferMoney
    double moneyOfReceiver
    double moneyOfSender

    @Override
    void refreshData() {
        //Refresh data from database
    }
}
