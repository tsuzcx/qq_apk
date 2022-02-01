package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher
{
  static Dispatcher immediate()
  {
    return ImmediateDispatcher.INSTANCE;
  }
  
  static Dispatcher legacyAsync()
  {
    return new LegacyAsyncDispatcher(null);
  }
  
  static Dispatcher perThreadDispatchQueue()
  {
    return new PerThreadQueuedDispatcher(null);
  }
  
  abstract void dispatch(Object paramObject, Iterator<Subscriber> paramIterator);
  
  static final class ImmediateDispatcher
    extends Dispatcher
  {
    private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      while (paramIterator.hasNext()) {
        ((Subscriber)paramIterator.next()).dispatchEvent(paramObject);
      }
    }
  }
  
  static final class LegacyAsyncDispatcher
    extends Dispatcher
  {
    private final ConcurrentLinkedQueue<EventWithSubscriber> queue = Queues.newConcurrentLinkedQueue();
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      while (paramIterator.hasNext()) {
        this.queue.add(new EventWithSubscriber(paramObject, (Subscriber)paramIterator.next(), null));
      }
      for (;;)
      {
        paramObject = (EventWithSubscriber)this.queue.poll();
        if (paramObject == null) {
          break;
        }
        paramObject.subscriber.dispatchEvent(paramObject.event);
      }
    }
    
    static final class EventWithSubscriber
    {
      private final Object event;
      private final Subscriber subscriber;
      
      private EventWithSubscriber(Object paramObject, Subscriber paramSubscriber)
      {
        this.event = paramObject;
        this.subscriber = paramSubscriber;
      }
    }
  }
  
  static final class PerThreadQueuedDispatcher
    extends Dispatcher
  {
    private final ThreadLocal<Boolean> dispatching = new Dispatcher.PerThreadQueuedDispatcher.2(this);
    private final ThreadLocal<Queue<Event>> queue = new Dispatcher.PerThreadQueuedDispatcher.1(this);
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      Preconditions.checkNotNull(paramIterator);
      Queue localQueue = (Queue)this.queue.get();
      localQueue.offer(new Event(paramObject, paramIterator, null));
      if (!((Boolean)this.dispatching.get()).booleanValue())
      {
        this.dispatching.set(Boolean.valueOf(true));
        try
        {
          paramObject = (Event)localQueue.poll();
          if (paramObject != null) {
            while (paramObject.subscribers.hasNext()) {
              ((Subscriber)paramObject.subscribers.next()).dispatchEvent(paramObject.event);
            }
          }
          this.dispatching.remove();
        }
        finally
        {
          this.dispatching.remove();
          this.queue.remove();
        }
        this.queue.remove();
      }
    }
    
    static final class Event
    {
      private final Object event;
      private final Iterator<Subscriber> subscribers;
      
      private Event(Object paramObject, Iterator<Subscriber> paramIterator)
      {
        this.event = paramObject;
        this.subscribers = paramIterator;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.Dispatcher
 * JD-Core Version:    0.7.0.1
 */