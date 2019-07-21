package con.huantt.chainofresponsibilitypattern

import con.huantt.chainofresponsibilitypattern.process.ChainContext
import con.huantt.chainofresponsibilitypattern.process.TransferMoneyProcessor
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
        boolean result = transferMoneyProcessor.transfer(senderCardId, receiverCardId, transferMoney)

        then:
        result == isCompleted
        chainContext.moneyOfSender == senderMoneyAfter
        chainContext.moneyOfReceiver == receiverMoneyAfter

        where:
        senderCardId   | receiverCardId | senderMoneyBefore | receiverMoneyBefore | transferMoney | isCompleted | senderMoneyAfter | receiverMoneyAfter
        "001096000000" | "001096000001" | 10000000D         | 1000000D            | 10000000D     | true        | 0D               | 11000000D
        "001096000000" | "001096000001" | 9000000D          | 1000000D            | 10000000D     | false       | 9000000D         | 1000000D
    }

}
