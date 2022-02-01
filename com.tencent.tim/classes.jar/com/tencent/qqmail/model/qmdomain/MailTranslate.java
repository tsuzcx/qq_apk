package com.tencent.qqmail.model.qmdomain;

public class MailTranslate
  extends QMDomain
{
  private String content;
  private long mailId;
  private String originalMailContent;
  private String originalMailSubj;
  private String subj;
  
  public long getMailId()
  {
    return this.mailId;
  }
  
  public String getOriginalMailContent()
  {
    return this.originalMailContent;
  }
  
  public String getOriginalMailSubj()
  {
    return this.originalMailSubj;
  }
  
  public String getTranslateContent()
  {
    return this.content;
  }
  
  public String getTranslateSubj()
  {
    return this.subj;
  }
  
  public void setMailId(long paramLong)
  {
    this.mailId = paramLong;
  }
  
  public void setOriginalMailContent(String paramString)
  {
    this.originalMailContent = paramString;
  }
  
  public void setOriginalMailSubj(String paramString)
  {
    this.originalMailSubj = paramString;
  }
  
  public void setTranslateContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setTranslateSubj(String paramString)
  {
    this.subj = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailTranslate\",");
    localStringBuffer.append("\"mailId\":\"" + getMailId() + "\",");
    if (getTranslateSubj() != null) {
      localStringBuffer.append("\"subj\":\"" + getTranslateSubj() + "\",");
    }
    if (getTranslateContent() != null) {
      localStringBuffer.append("\"content\":\"" + getTranslateContent() + "\"");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailTranslate
 * JD-Core Version:    0.7.0.1
 */