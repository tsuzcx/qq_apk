package com.tencent.moai.mailsdk.protocol.activesync.Status;

public abstract class ActiveSyncStatus
{
  protected int status;
  
  public ActiveSyncStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public abstract String getStatusMsg();
  
  public boolean isRedirect()
  {
    return this.status == 451;
  }
  
  public boolean isStatusOk()
  {
    return this.status == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.ActiveSyncStatus
 * JD-Core Version:    0.7.0.1
 */