package com.airhacks.doit.business.logging.boundary;

import com.airhacks.doit.business.monitoring.entity.CallEvent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class BoundaryLogger {

    @Inject
    Event<CallEvent> monitoring;

    //means then some annotation @Interceptors will call this method 
    //when execute some methods is basically a hook or ascpect on Spring 
    @AroundInvoke 
    public Object logCall(InvocationContext ic) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            monitoring.fire(new CallEvent(ic.getMethod().getName(), duration));
        }
    }

}
