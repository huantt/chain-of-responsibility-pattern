package com.huantt.chainofresponsibilitypattern.process

import com.huantt.chainofresponsibilitypattern.base.Chain
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-07-21
 */
@CompileStatic
@Service
class TransferMoneyProcessor {

    @Autowired
    ChainContext chainContext
    @Autowired
    ChargeMoneyOfSender chargeMoneyOfSender
    @Autowired
    IncreaseMoneyForReceiver increaseMoneyForReceiver

    Chain.STATUS transfer(String senderCardNumber, String receiverCardNumber, double transferMoney) {
        chainContext.with {
            setSenderCardNumber(senderCardNumber)
            setReceiverCardNumber(receiverCardNumber)
            setTransferMoney(transferMoney)
        }
        chainContext.refreshData()

        Chain chain = new Chain([
                chargeMoneyOfSender,
                increaseMoneyForReceiver
        ] as LinkedList)

        chain.execute()
    }

}
