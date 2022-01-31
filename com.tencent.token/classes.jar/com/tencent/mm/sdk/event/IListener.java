package com.tencent.mm.sdk.event;

public abstract class IListener
{
  private final int priority;
  
  public IListener(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public abstract boolean callback(IEvent paramIEvent);
  
  public int getPriority()
  {
    return this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IListener
 * JD-Core Version:    0.7.0.1
 */