package com.huantt.chainofresponsibilitypattern.base

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
/**
 * @author huantt on 2019-07-20
 */
@CompileStatic
abstract class BaseChainProcess<C extends BaseChainContext> {

    public static enum RESPONSE {
        CONTINUE_PROCESSING, PROCESSING_COMPLETE, PROCESSING_COMPLETE_EARLY
    }

    @Autowired
    protected C context

    public abstract RESPONSE execute()
}