package com.tencent.mm.sdk.event;

import android.os.Looper;

public abstract interface EventPoolFactory$IEventPool
{
  public abstract boolean add(String paramString, IListener paramIListener);
  
  public abstract void asyncPublish(IEvent paramIEvent);
  
  public abstract void asyncPublish(IEvent paramIEvent, Looper paramLooper);
  
  public abstract void publish(IEvent paramIEvent);
  
  public abstract void release(int paramInt);
  
  public abstract boolean remove(String paramString, IListener paramIListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventPoolFactory.IEventPool
 * JD-Core Version:    0.7.0.1
 */