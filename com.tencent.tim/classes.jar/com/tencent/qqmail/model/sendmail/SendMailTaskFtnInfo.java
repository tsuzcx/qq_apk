package com.tencent.qqmail.model.sendmail;

public class SendMailTaskFtnInfo
{
  private long attachId;
  private String fid;
  private String rid;
  
  public SendMailTaskFtnInfo(long paramLong, String paramString1, String paramString2)
  {
    this.attachId = paramLong;
    this.rid = paramString1;
    this.fid = paramString2;
  }
  
  public long getAttachId()
  {
    return this.attachId;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getRid()
  {
    return this.rid;
  }
  
  public void setAttachId(long paramLong)
  {
    this.attachId = paramLong;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setRid(String paramString)
  {
    this.rid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailTaskFtnInfo
 * JD-Core Version:    0.7.0.1
 */