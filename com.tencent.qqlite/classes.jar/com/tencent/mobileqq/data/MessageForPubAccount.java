package com.tencent.mobileqq.data;

import com.tencent.biz.pubaccount.util.PAMessageUtil;

public class MessageForPubAccount
  extends ChatMessage
{
  public PAMessage mPAMessage = null;
  
  protected void doParse()
  {
    try
    {
      this.mPAMessage = PAMessageUtil.a(this.msgData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void prewrite()
  {
    if (this.mPAMessage != null) {}
    try
    {
      this.msgData = PAMessageUtil.a(this.mPAMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPubAccount
 * JD-Core Version:    0.7.0.1
 */