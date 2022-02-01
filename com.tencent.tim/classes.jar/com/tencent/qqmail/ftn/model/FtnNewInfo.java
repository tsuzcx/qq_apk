package com.tencent.qqmail.ftn.model;

public final class FtnNewInfo
{
  private String absolutePath;
  private long createTime;
  private long expireTime;
  private String fid;
  private long fileSize;
  private String name;
  private String sha;
  
  public FtnNewInfo(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, String paramString4)
  {
    this.fid = paramString1;
    this.name = paramString2;
    this.sha = paramString3;
    this.createTime = paramLong1;
    this.expireTime = paramLong2;
    this.fileSize = paramLong3;
    this.absolutePath = paramString4;
  }
  
  public String getAbsolutePath()
  {
    return this.absolutePath;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public long getExpireTime()
  {
    return this.expireTime;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSha()
  {
    return this.sha;
  }
  
  public void setAbsolutePath(String paramString)
  {
    this.absolutePath = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setExpireTime(long paramLong)
  {
    this.expireTime = paramLong;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSha(String paramString)
  {
    this.sha = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnNewInfo
 * JD-Core Version:    0.7.0.1
 */