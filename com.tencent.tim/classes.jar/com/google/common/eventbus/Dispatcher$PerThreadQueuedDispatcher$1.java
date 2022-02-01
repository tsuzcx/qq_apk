package com.google.common.eventbus;

import com.google.common.collect.Queues;
import java.util.Queue;

class Dispatcher$PerThreadQueuedDispatcher$1
  extends ThreadLocal<Queue<Dispatcher.PerThreadQueuedDispatcher.Event>>
{
  Dispatcher$PerThreadQueuedDispatcher$1(Dispatcher.PerThreadQueuedDispatcher paramPerThreadQueuedDispatcher) {}
  
  protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> initialValue()
  {
    return Queues.newArrayDeque();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
 * JD-Core Version:    0.7.0.1
 */