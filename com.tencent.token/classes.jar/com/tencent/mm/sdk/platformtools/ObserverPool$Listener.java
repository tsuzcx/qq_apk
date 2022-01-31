package com.tencent.mm.sdk.platformtools;

public abstract class ObserverPool$Listener
{
  private final int priority;
  
  public ObserverPool$Listener()
  {
    this.priority = 0;
  }
  
  public ObserverPool$Listener(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public abstract boolean callback(ObserverPool.Event paramEvent);
  
  public int getPriority()
  {
    return this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool.Listener
 * JD-Core Version:    0.7.0.1
 */