package com.tencent.moai.mailsdk.protocol.pop3;

public class POP3MsgStatus
{
  private static int maxLineSize = 156;
  private int msgNum;
  private long size;
  
  public int getMinMsgLine()
  {
    return (int)this.size / maxLineSize;
  }
  
  public int getMsgNum()
  {
    return this.msgNum;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void setMsgNum(int paramInt)
  {
    this.msgNum = paramInt;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.pop3.POP3MsgStatus
 * JD-Core Version:    0.7.0.1
 */