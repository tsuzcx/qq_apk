package com.tencent.mm.sdk.event;

public abstract interface IEvent
{
  public static final int EVENT_SCOPE_APPLICATION = 2;
  public static final int EVENT_SCOPE_SESSION = 1;
  public static final int EVENT_SCOPE_TEMPL = 0;
  
  public abstract String getId();
  
  public abstract String getScope();
  
  public abstract boolean isOrder();
  
  public abstract void oncomplete();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IEvent
 * JD-Core Version:    0.7.0.1
 */