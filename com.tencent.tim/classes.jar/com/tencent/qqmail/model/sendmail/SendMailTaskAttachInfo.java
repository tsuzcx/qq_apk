package com.tencent.qqmail.model.sendmail;

public class SendMailTaskAttachInfo
{
  private String fileId;
  private String path;
  private int taskId;
  private String url;
  
  public SendMailTaskAttachInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.taskId = paramInt;
    this.path = paramString1;
    this.url = paramString2;
    this.fileId = paramString3;
  }
  
  public String getFileId()
  {
    return this.fileId;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getTaskId()
  {
    return this.taskId;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setFileId(String paramString)
  {
    this.fileId = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setTaskId(int paramInt)
  {
    this.taskId = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailTaskAttachInfo
 * JD-Core Version:    0.7.0.1
 */