package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class SubscribeReq
  implements IMessageEntity
{
  @Packed
  private String operation;
  @Packed
  private String packageName;
  @Packed
  private String token;
  @Packed
  private String topic;
  
  public SubscribeReq() {}
  
  public SubscribeReq(String paramString1, String paramString2, String paramString3)
  {
    this.packageName = paramString1;
    this.operation = paramString2;
    this.topic = paramString3;
  }
  
  public String getOperation()
  {
    return this.operation;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getTopic()
  {
    return this.topic;
  }
  
  public void setOperation(String paramString)
  {
    this.operation = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTopic(String paramString)
  {
    this.topic = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubscribeReq{");
    localStringBuilder.append("packageName='").append(this.packageName).append('\'');
    localStringBuilder.append(", operation='").append(this.operation).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.SubscribeReq
 * JD-Core Version:    0.7.0.1
 */