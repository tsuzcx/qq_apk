package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class NOPLoggerFactory
  implements ILoggerFactory
{
  public Logger getLogger(String paramString)
  {
    return NOPLogger.NOP_LOGGER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.helpers.NOPLoggerFactory
 * JD-Core Version:    0.7.0.1
 */