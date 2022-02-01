package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

public abstract interface LoggerFactoryBinder
{
  public abstract ILoggerFactory getLoggerFactory();
  
  public abstract String getLoggerFactoryClassStr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.spi.LoggerFactoryBinder
 * JD-Core Version:    0.7.0.1
 */