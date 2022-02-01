package org.slf4j.event;

import org.slf4j.Marker;

public abstract interface LoggingEvent
{
  public abstract Object[] getArgumentArray();
  
  public abstract Level getLevel();
  
  public abstract String getLoggerName();
  
  public abstract Marker getMarker();
  
  public abstract String getMessage();
  
  public abstract String getThreadName();
  
  public abstract Throwable getThrowable();
  
  public abstract long getTimeStamp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.event.LoggingEvent
 * JD-Core Version:    0.7.0.1
 */