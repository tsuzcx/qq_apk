package com.tencent.qqmail.download.model;

public class BigAttachDownloadError
{
  private String svrCode;
  private String svrIp;
  
  public BigAttachDownloadError(String paramString1, String paramString2)
  {
    this.svrCode = paramString1;
    this.svrIp = paramString2;
  }
  
  public String getSvrCode()
  {
    return this.svrCode;
  }
  
  public String getSvrIp()
  {
    return this.svrIp;
  }
  
  public void setSvrCode(String paramString)
  {
    this.svrCode = paramString;
  }
  
  public void setSvrIp(String paramString)
  {
    this.svrIp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.model.BigAttachDownloadError
 * JD-Core Version:    0.7.0.1
 */