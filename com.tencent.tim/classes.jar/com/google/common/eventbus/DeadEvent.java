package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;

@Beta
public class DeadEvent
{
  private final Object event;
  private final Object source;
  
  public DeadEvent(Object paramObject1, Object paramObject2)
  {
    this.source = Preconditions.checkNotNull(paramObject1);
    this.event = Preconditions.checkNotNull(paramObject2);
  }
  
  public Object getEvent()
  {
    return this.event;
  }
  
  public Object getSource()
  {
    return this.source;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(this).add("source", this.source).add("event", this.event).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.DeadEvent
 * JD-Core Version:    0.7.0.1
 */