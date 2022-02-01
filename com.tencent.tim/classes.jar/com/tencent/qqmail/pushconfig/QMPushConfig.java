package com.tencent.qqmail.pushconfig;

public class QMPushConfig
{
  protected String content;
  protected int hash;
  protected int id;
  protected int type;
  protected int version;
  
  public QMPushConfig() {}
  
  public QMPushConfig(QMPushConfig paramQMPushConfig)
  {
    setId(paramQMPushConfig.getId());
    setType(paramQMPushConfig.getType());
    setVersion(paramQMPushConfig.getVersion());
    setContent(paramQMPushConfig.getContent());
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getHash()
  {
    return this.hash;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setHash(int paramInt)
  {
    this.hash = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public String toString()
  {
    return String.format("%d,%d,%d,%d,%s", new Object[] { Integer.valueOf(this.id), Integer.valueOf(this.type), Integer.valueOf(this.hash), Integer.valueOf(this.version), this.content });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfig
 * JD-Core Version:    0.7.0.1
 */