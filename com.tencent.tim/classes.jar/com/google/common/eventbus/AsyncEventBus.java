package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public class AsyncEventBus
  extends EventBus
{
  public AsyncEventBus(String paramString, Executor paramExecutor)
  {
    super(paramString, paramExecutor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
  }
  
  public AsyncEventBus(Executor paramExecutor)
  {
    super("default", paramExecutor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
  }
  
  public AsyncEventBus(Executor paramExecutor, SubscriberExceptionHandler paramSubscriberExceptionHandler)
  {
    super("default", paramExecutor, Dispatcher.legacyAsync(), paramSubscriberExceptionHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.AsyncEventBus
 * JD-Core Version:    0.7.0.1
 */