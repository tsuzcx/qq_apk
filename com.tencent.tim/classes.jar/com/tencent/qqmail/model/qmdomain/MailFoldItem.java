package com.tencent.qqmail.model.qmdomain;

public class MailFoldItem
  extends QMDomain
{
  private static final long serialVersionUID = 4116470263059697750L;
  private boolean canExpend;
  private String content;
  
  public String getContent()
  {
    return this.content;
  }
  
  public boolean isCanExpend()
  {
    return this.canExpend;
  }
  
  public void setCanExpend(boolean paramBoolean)
  {
    this.canExpend = paramBoolean;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailFoldItem
 * JD-Core Version:    0.7.0.1
 */