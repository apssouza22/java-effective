package com.airhacks.doit.business.logging.boundary;

/**
 *
 * @author airhacks.com
 */
//this make possible the implementation of interface on the fly
// we can return a function on factory.
//Basicaly here we are return a Logger.getLogger(classname)::info on factory
@FunctionalInterface
public interface LogSink {

    void log(String msg);
}
