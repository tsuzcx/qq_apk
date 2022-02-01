package com.tencent.moai.mailsdk.protocol.pop3;

public class POP3Status
{
  private int msgCount;
  private long msgSize;
  
  public int getMsgCount()
  {
    return this.msgCount;
  }
  
  public long getMsgSize()
  {
    return this.msgSize;
  }
  
  public void setMsgCount(int paramInt)
  {
    this.msgCount = paramInt;
  }
  
  public void setMsgSize(long paramLong)
  {
    this.msgSize = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.pop3.POP3Status
 * JD-Core Version:    0.7.0.1
 */