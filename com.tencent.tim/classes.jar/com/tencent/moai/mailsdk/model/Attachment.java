package com.tencent.moai.mailsdk.model;

import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;

public class Attachment
{
  public static final String TYPE_ATTACHMENT = "attachment";
  public static final String TYPE_INLINE = "inline";
  private String cid;
  private String fid;
  private IMAPBodyStructure imapBodyStructure;
  private String name;
  private String path;
  private long size;
  private String type;
  
  public String getCid()
  {
    return this.cid;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public IMAPBodyStructure getImapBodyStructure()
  {
    return this.imapBodyStructure;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setCid(String paramString)
  {
    this.cid = paramString;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setImapBodyStructure(IMAPBodyStructure paramIMAPBodyStructure)
  {
    this.imapBodyStructure = paramIMAPBodyStructure;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Attachment
 * JD-Core Version:    0.7.0.1
 */