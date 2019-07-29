package com.huantt.chainofresponsibilitypattern

import com.huantt.chainofresponsibilitypattern.base.Chain
import com.huantt.chainofresponsibilitypattern.process.ChainContext
import com.huantt.chainofresponsibilitypattern.process.TransferMoneyProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class AppTest extends Specification {

    @Autowired
    TransferMoneyProcessor transferMoneyProcessor
    @Autowired
    ChainContext chainContext

    @Unroll
    void "Test transfer money"() {
        given: "Mock refreshing data for ChainContext"
        chainContext.moneyOfSender = senderMoneyBefore
        chainContext.moneyOfReceiver = receiverMoneyBefore
        chainContext.transferMoney = transferMoney

        when: "Try transferring"
        Chain.STATUS result = transferMoneyProcessor.transfer(senderCardId, receiverCardId, transferMoney)

        then:
        result == resultStatus
        chainContext.moneyOfSender == senderMoneyAfter
        chainContext.moneyOfReceiver == receiverMoneyAfter

        where:
        senderCardId   | receiverCardId | senderMoneyBefore | receiverMoneyBefore | transferMoney | resultStatus                  | senderMoneyAfter | receiverMoneyAfter
        "001096000000" | "001096000001" | 10000000D         | 1000000D            | 10000000D     | Chain.STATUS.COMPLETED  | 0D               | 11000000D
        "001096000000" | "001096000001" | 9000000D          | 1000000D            | 10000000D     | Chain.STATUS.INCOMPLETE | 9000000D         | 1000000D
    }

}
