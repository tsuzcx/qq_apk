package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.exception.MessageException;

public abstract interface Handler
{
  public abstract void auth(boolean paramBoolean)
    throws MessageException;
  
  public abstract void closeConnection();
  
  public abstract String getTag();
  
  public abstract boolean isAuthenticate();
  
  public abstract boolean isConnected();
  
  public abstract void openConnection()
    throws MessageException;
  
  public abstract void setTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.Handler
 * JD-Core Version:    0.7.0.1
 */