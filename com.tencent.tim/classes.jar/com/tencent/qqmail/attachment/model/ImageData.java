package com.tencent.qqmail.attachment.model;

import com.tencent.qqmail.ftn.Ftn.FileInfo;
import java.io.Serializable;

public class ImageData
  implements Serializable
{
  private int accountId;
  private String code;
  private int createTime;
  private String downCookie = "";
  private String downUrl = "";
  private int downloadTime;
  private int expireTime;
  private String fid;
  private FileInfo fileInfo;
  private int itemPos;
  private String key;
  private String name;
  private String shareUrl = "";
  private String size;
  private String suffix;
  private String thumbUrl = "";
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public int getCreateTime()
  {
    return this.createTime;
  }
  
  public String getDownCookie()
  {
    return this.downCookie;
  }
  
  public String getDownUrl()
  {
    return this.downUrl;
  }
  
  public int getDownloadTime()
  {
    return this.downloadTime;
  }
  
  public int getExpireTime()
  {
    return this.expireTime;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public FileInfo getFileInfo()
  {
    return this.fileInfo;
  }
  
  public int getItemPos()
  {
    return this.itemPos;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getShareUrl()
  {
    return this.shareUrl;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getSuffix()
  {
    return this.suffix;
  }
  
  public String getThumbUrl()
  {
    return this.thumbUrl;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCreateTime(int paramInt)
  {
    this.createTime = paramInt;
  }
  
  public void setDownCookie(String paramString)
  {
    this.downCookie = paramString;
  }
  
  public void setDownUrl(String paramString)
  {
    this.downUrl = paramString;
  }
  
  public void setDownloadTime(int paramInt)
  {
    this.downloadTime = paramInt;
  }
  
  public void setExpireTime(int paramInt)
  {
    this.expireTime = paramInt;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setFileInfo(FileInfo paramFileInfo)
  {
    this.fileInfo = paramFileInfo;
  }
  
  public void setItemPos(int paramInt)
  {
    this.itemPos = paramInt;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setShareUrl(String paramString)
  {
    this.shareUrl = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
  }
  
  public void setThumbUrl(String paramString)
  {
    this.thumbUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.ImageData
 * JD-Core Version:    0.7.0.1
 */