package com.huantt.chainofresponsibilitypattern

import com.huantt.chainofresponsibilitypattern.process.TransferMoneyProcessor
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class App {

    static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args)
        TransferMoneyProcessor transferMoneyProcessor = context.getBean(TransferMoneyProcessor)
        transferMoneyProcessor.transfer("001096000000", "001096000001", 1000000D)
    }

}
