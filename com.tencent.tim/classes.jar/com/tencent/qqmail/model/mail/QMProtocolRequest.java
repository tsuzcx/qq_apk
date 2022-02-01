package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.utilities.qmnetwork.IAbortable;

public class QMProtocolRequest
  implements IAbortable
{
  private boolean hasRequestSent = false;
  private boolean isAbort = false;
  
  public void abort()
  {
    this.isAbort = true;
  }
  
  public boolean isAbort()
  {
    return this.isAbort;
  }
  
  public boolean isHasRequestSent()
  {
    return this.hasRequestSent;
  }
  
  public void setHasSendRequest(boolean paramBoolean)
  {
    this.hasRequestSent = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMProtocolRequest
 * JD-Core Version:    0.7.0.1
 */