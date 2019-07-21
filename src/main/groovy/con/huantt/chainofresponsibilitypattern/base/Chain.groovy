package con.huantt.chainofresponsibilitypattern.base

import groovy.transform.CompileStatic

/**
 * @author huantt on 2019-07-20
 */
@CompileStatic
class Chain<P extends BaseChainProcess> {

    public static final boolean COMPLETED = true
    public static final boolean INCOMPLETE = false

    private LinkedList<P> processes

    Chain(LinkedList<P> processes) {
        this.processes = processes
    }

    boolean execute() {
        for (P process in processes) {
            if (process.execute() == BaseChainProcess.PROCESSING_COMPLETE) return INCOMPLETE
        }
        return COMPLETED
    }

}
