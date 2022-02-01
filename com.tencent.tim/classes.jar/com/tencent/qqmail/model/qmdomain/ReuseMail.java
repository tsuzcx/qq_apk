package com.tencent.qqmail.model.qmdomain;

import java.io.Serializable;

public class ReuseMail
  implements Serializable
{
  private MailContent content;
  private MailInformation info;
  private boolean isRead;
  private MailStatus status;
  private MailVote vote;
  
  public MailContent getContent()
  {
    return this.content;
  }
  
  public MailInformation getInfo()
  {
    return this.info;
  }
  
  public MailStatus getStatus()
  {
    return this.status;
  }
  
  public MailVote getVote()
  {
    return this.vote;
  }
  
  public boolean isRead()
  {
    return this.isRead;
  }
  
  public void setContent(MailContent paramMailContent)
  {
    this.content = paramMailContent;
  }
  
  public void setInfo(MailInformation paramMailInformation)
  {
    this.info = paramMailInformation;
  }
  
  public void setIsRead(boolean paramBoolean)
  {
    this.isRead = paramBoolean;
  }
  
  public void setStatus(MailStatus paramMailStatus)
  {
    this.status = paramMailStatus;
  }
  
  public void setVote(MailVote paramMailVote)
  {
    this.vote = paramMailVote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ReuseMail
 * JD-Core Version:    0.7.0.1
 */