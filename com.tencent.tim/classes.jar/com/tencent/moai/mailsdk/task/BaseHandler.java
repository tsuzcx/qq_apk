package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.exception.MessageException;

public class BaseHandler
  implements Handler
{
  private String tag;
  
  public void auth(boolean paramBoolean)
    throws MessageException
  {}
  
  public void closeConnection() {}
  
  public String getTag()
  {
    return this.tag;
  }
  
  public boolean isAuthenticate()
  {
    return true;
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public void openConnection()
    throws MessageException
  {}
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.BaseHandler
 * JD-Core Version:    0.7.0.1
 */