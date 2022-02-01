package com.tencent.beacon.event;

import java.io.Serializable;
import java.util.Map;

public final class EventBean
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String apn;
  private String appKey;
  private byte[] byteValue;
  private long cid = -1L;
  private String eventCode;
  private boolean eventResult = true;
  private long eventTime;
  private int eventType;
  private Map<String, String> eventValue;
  private String reserved;
  private String srcIp;
  private int valueType;
  
  public String getApn()
  {
    return this.apn;
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public byte[] getByteValue()
  {
    return this.byteValue;
  }
  
  public long getCid()
  {
    return this.cid;
  }
  
  public String getEventCode()
  {
    return this.eventCode;
  }
  
  public boolean getEventResult()
  {
    return this.eventResult;
  }
  
  public long getEventTime()
  {
    return this.eventTime;
  }
  
  public int getEventType()
  {
    return this.eventType;
  }
  
  public Map<String, String> getEventValue()
  {
    return this.eventValue;
  }
  
  public String getReserved()
  {
    return this.reserved;
  }
  
  public String getSrcIp()
  {
    return this.srcIp;
  }
  
  public int getValueType()
  {
    return this.valueType;
  }
  
  public void setApn(String paramString)
  {
    this.apn = paramString;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setByteValue(byte[] paramArrayOfByte)
  {
    this.byteValue = paramArrayOfByte;
  }
  
  public void setCid(long paramLong)
  {
    this.cid = paramLong;
  }
  
  public void setEventCode(String paramString)
  {
    this.eventCode = paramString;
  }
  
  public void setEventResult(boolean paramBoolean)
  {
    this.eventResult = paramBoolean;
  }
  
  public void setEventTime(long paramLong)
  {
    this.eventTime = paramLong;
  }
  
  public void setEventType(int paramInt)
  {
    this.eventType = paramInt;
  }
  
  public void setEventValue(Map<String, String> paramMap)
  {
    this.eventValue = paramMap;
  }
  
  public void setReserved(String paramString)
  {
    this.reserved = paramString;
  }
  
  public void setSrcIp(String paramString)
  {
    this.srcIp = paramString;
  }
  
  public void setValueType(int paramInt)
  {
    this.valueType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.EventBean
 * JD-Core Version:    0.7.0.1
 */