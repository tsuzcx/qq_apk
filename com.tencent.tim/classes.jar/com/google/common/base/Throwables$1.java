package com.google.common.base;

import java.util.AbstractList;

final class Throwables$1
  extends AbstractList<StackTraceElement>
{
  Throwables$1(Throwable paramThrowable) {}
  
  public StackTraceElement get(int paramInt)
  {
    return (StackTraceElement)Throwables.access$200(Throwables.access$000(), Throwables.access$100(), new Object[] { this.val$t, Integer.valueOf(paramInt) });
  }
  
  public int size()
  {
    return ((Integer)Throwables.access$200(Throwables.access$300(), Throwables.access$100(), new Object[] { this.val$t })).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Throwables.1
 * JD-Core Version:    0.7.0.1
 */