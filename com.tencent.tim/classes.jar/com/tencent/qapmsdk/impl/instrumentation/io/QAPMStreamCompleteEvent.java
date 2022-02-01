package com.tencent.qapmsdk.impl.instrumentation.io;

import java.util.EventObject;

public class QAPMStreamCompleteEvent
  extends EventObject
{
  private static final long serialVersionUID = 1L;
  private final long bytes;
  private final Exception exception;
  
  public QAPMStreamCompleteEvent(Object paramObject, long paramLong)
  {
    this(paramObject, paramLong, (Exception)null);
  }
  
  public QAPMStreamCompleteEvent(Object paramObject, long paramLong, Exception paramException)
  {
    super(paramObject);
    this.bytes = paramLong;
    this.exception = paramException;
  }
  
  public long getBytes()
  {
    return this.bytes;
  }
  
  public Exception getException()
  {
    return this.exception;
  }
  
  public boolean isError()
  {
    return this.exception != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent
 * JD-Core Version:    0.7.0.1
 */