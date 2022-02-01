package com.immersion.touchsensesdk;

import java.io.IOException;

public abstract interface IConnection
{
  public abstract void disconnect();
  
  public abstract int getContentLength();
  
  public abstract long getLastModified();
  
  public abstract int getResponseCode()
    throws IOException;
  
  public abstract byte[] readAllData()
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.immersion.touchsensesdk.IConnection
 * JD-Core Version:    0.7.0.1
 */