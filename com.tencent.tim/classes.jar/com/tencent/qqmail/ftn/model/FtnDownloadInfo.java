package com.tencent.qqmail.ftn.model;

public class FtnDownloadInfo
{
  private long createTime;
  private String fid;
  private String savePath;
  private long size;
  
  public FtnDownloadInfo(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.fid = paramString1;
    this.savePath = paramString2;
    this.createTime = paramLong1;
    this.size = paramLong2;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getSavePath()
  {
    return this.savePath;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setSavePath(String paramString)
  {
    this.savePath = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public String toString()
  {
    return "{" + "fid: " + this.fid + "," + "savePath: " + this.savePath + "," + "createTIme: " + this.createTime + "," + "size: " + this.size + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnDownloadInfo
 * JD-Core Version:    0.7.0.1
 */