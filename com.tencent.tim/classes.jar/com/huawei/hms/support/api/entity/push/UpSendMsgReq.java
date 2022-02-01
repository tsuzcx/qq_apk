package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class UpSendMsgReq
  implements IMessageEntity
{
  @Packed
  private String collapseKey;
  @Packed
  private String data;
  @Packed
  private String msgId;
  @Packed
  private String msgType;
  @Packed
  private String packageName;
  @Packed
  private String to;
  @Packed
  private String token;
  @Packed
  private int ttl;
  
  public String getCollapseKey()
  {
    return this.collapseKey;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getMessageId()
  {
    return this.msgId;
  }
  
  public String getMessageType()
  {
    return this.msgType;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getTo()
  {
    return this.to;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public int getTtl()
  {
    return this.ttl;
  }
  
  public void setCollapseKey(String paramString)
  {
    this.collapseKey = paramString;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setMessageId(String paramString)
  {
    this.msgId = paramString;
  }
  
  public void setMessageType(String paramString)
  {
    this.msgType = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setTo(String paramString)
  {
    this.to = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTtl(int paramInt)
  {
    this.ttl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.UpSendMsgReq
 * JD-Core Version:    0.7.0.1
 */