package com.huantt.chainofresponsibilitypattern.base

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

/**
 * @author huantt on 2019-07-20
 */
@CompileStatic
@Slf4j
class Chain<M extends BaseChainProcess> {

    public static enum STATUS {
        COMPLETED, INCOMPLETE
    }

    private LinkedList<M> processes

    Chain(LinkedList<M> processes) {
        this.processes = processes
    }

    /**
     * Completed chain definition: All of processes must completed.
     */
    STATUS execute() {
        for (M process in processes) {
            log.debug("Processing {}", process.class.simpleName)
            switch (process.execute()) {
                case BaseChainProcess.RESPONSE.CONTINUE_PROCESSING:
                    continue
                case BaseChainProcess.RESPONSE.PROCESSING_COMPLETE:
                    log.debug("Processor is completed!")
                    return STATUS.COMPLETED
                case BaseChainProcess.RESPONSE.PROCESSING_COMPLETE_EARLY:
                    log.debug("Processor is completed early at {}", process.class.simpleName)
                    return STATUS.INCOMPLETE
            }
        }
        return STATUS.COMPLETED
    }


}
