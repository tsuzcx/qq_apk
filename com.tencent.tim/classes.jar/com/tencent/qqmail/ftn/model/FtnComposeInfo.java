package com.tencent.qqmail.ftn.model;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import java.io.Serializable;

public class FtnComposeInfo
  implements Serializable
{
  private String fid;
  private String href;
  private MailBigAttach mailAttach;
  private String name;
  private String size;
  private String thumbUrl;
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getHref()
  {
    return this.href;
  }
  
  public MailBigAttach getMailAttach()
  {
    return this.mailAttach;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getThumbUrl()
  {
    return this.thumbUrl;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setHref(String paramString)
  {
    this.href = paramString;
  }
  
  public void setMailAttach(MailBigAttach paramMailBigAttach)
  {
    this.mailAttach = paramMailBigAttach;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setThumbUrl(String paramString)
  {
    this.thumbUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnComposeInfo
 * JD-Core Version:    0.7.0.1
 */