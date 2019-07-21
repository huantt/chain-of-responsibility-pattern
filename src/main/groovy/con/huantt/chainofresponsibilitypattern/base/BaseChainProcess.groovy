package con.huantt.chainofresponsibilitypattern.base

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
/**
 * @author huantt on 2019-07-20
 */
@CompileStatic
abstract class BaseChainProcess<C extends BaseChainContext> {

    public static final boolean CONTINUE_PROCESSING = false
    public static final boolean PROCESSING_COMPLETE = true

    @Autowired
    protected C context

    public abstract boolean execute()
}