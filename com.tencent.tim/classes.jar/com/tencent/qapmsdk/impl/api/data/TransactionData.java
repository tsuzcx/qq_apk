package com.tencent.qapmsdk.impl.api.data;

import com.tencent.qapmsdk.impl.harvest.HttpLibType;
import com.tencent.qapmsdk.impl.harvest.RequestMethodType;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.b;

public class TransactionData
{
  private String allGetRequestParams;
  private final String appData;
  private final long byteSent;
  private final long bytesReceived;
  private final String carrier;
  private String cdnHeaderName = "";
  private String contentType;
  private int dnsElapse;
  private final int eee;
  private int errorCode;
  private int firstPackageTime;
  private final String formattedUrlParams;
  private String hostAddress;
  private HttpLibType httpLibType;
  private final Object lock = new Object();
  private int queueTime;
  private RequestMethodType requestMethodType;
  private int sslHandShakeTime;
  private final long startTimeStamp;
  private int statusCode;
  private int tcpHandShakeTime;
  private int time;
  private final long timestamp;
  private int totalSocketTime = -1;
  private TraceType.b traceType;
  private final String url = trimmedUrl(paramString1);
  private String userActionId;
  
  public TransactionData(String paramString1, String paramString2, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, String paramString3, String paramString4, String paramString5, RequestMethodType paramRequestMethodType, HttpLibType paramHttpLibType, int paramInt4, String paramString6, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, String paramString9, String paramString10, int paramInt9)
  {
    this.carrier = paramString2;
    this.startTimeStamp = paramLong1;
    this.time = paramInt1;
    this.statusCode = paramInt2;
    this.errorCode = paramInt3;
    this.byteSent = paramLong2;
    this.bytesReceived = paramLong3;
    this.appData = paramString3;
    this.timestamp = System.currentTimeMillis();
    this.formattedUrlParams = paramString4;
    this.requestMethodType = paramRequestMethodType;
    this.httpLibType = paramHttpLibType;
    this.dnsElapse = paramInt4;
    this.hostAddress = paramString6;
    this.tcpHandShakeTime = paramInt5;
    this.sslHandShakeTime = paramInt6;
    this.firstPackageTime = paramInt7;
    this.cdnHeaderName = paramString7;
    this.contentType = paramString8;
    this.eee = paramInt8;
    this.traceType = this.traceType;
    this.userActionId = paramString9;
    this.allGetRequestParams = paramString10;
    this.queueTime = paramInt9;
  }
  
  private String trimmedUrl(String paramString)
  {
    int j = paramString.indexOf("?");
    int i = j;
    if (j < 0)
    {
      j = paramString.indexOf(";");
      i = j;
      if (j < 0) {
        i = paramString.length();
      }
    }
    return paramString.substring(0, i);
  }
  
  public void addTime(int paramInt)
  {
    if (paramInt > 0) {
      this.time += paramInt;
    }
  }
  
  public String getAllGetRequestParams()
  {
    return this.allGetRequestParams;
  }
  
  public String getAppData()
  {
    return this.appData;
  }
  
  public long getByteSent()
  {
    return this.byteSent;
  }
  
  public long getBytesReceived()
  {
    return this.bytesReceived;
  }
  
  public String getCarrier()
  {
    return this.carrier;
  }
  
  public String getCdnHeaderName()
  {
    return this.cdnHeaderName;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public int getDnsElapse()
  {
    return this.dnsElapse;
  }
  
  public int getErrorCode()
  {
    synchronized (this.lock)
    {
      int i = this.errorCode;
      return i;
    }
  }
  
  public int getFirstPackageTime()
  {
    return this.firstPackageTime;
  }
  
  public String getFormattedUrlParams()
  {
    return this.formattedUrlParams;
  }
  
  public String getHostAddress()
  {
    return this.hostAddress;
  }
  
  public HttpLibType getHttpLibType()
  {
    return this.httpLibType;
  }
  
  public int getQueueTime()
  {
    return this.queueTime;
  }
  
  public RequestMethodType getRequestMethodType()
  {
    return this.requestMethodType;
  }
  
  public int getSslHandShakeTime()
  {
    return this.sslHandShakeTime;
  }
  
  public long getStartTimeStamp()
  {
    return this.startTimeStamp;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public int getTcpHandShakeTime()
  {
    return this.tcpHandShakeTime;
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getTotalSocketTime()
  {
    return this.totalSocketTime;
  }
  
  public TraceType.b getTraceType()
  {
    return this.traceType;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getUserActionId()
  {
    return this.userActionId;
  }
  
  public int l()
  {
    return this.eee;
  }
  
  public void setCdnHeaderName(String paramString)
  {
    this.cdnHeaderName = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
  
  public void setDnsElapse(int paramInt)
  {
    this.dnsElapse = paramInt;
  }
  
  public void setErrorCode(int paramInt)
  {
    synchronized (this.lock)
    {
      this.errorCode = paramInt;
      return;
    }
  }
  
  public void setFirstPackageTime(int paramInt)
  {
    this.firstPackageTime = paramInt;
  }
  
  public void setHostAddress(String paramString)
  {
    this.hostAddress = paramString;
  }
  
  public void setHttpLibType(HttpLibType paramHttpLibType)
  {
    this.httpLibType = paramHttpLibType;
  }
  
  public void setRequestMethodType(RequestMethodType paramRequestMethodType)
  {
    this.requestMethodType = paramRequestMethodType;
  }
  
  public void setSslHandShakeTime(int paramInt)
  {
    this.sslHandShakeTime = paramInt;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void setTcpHandShakeTime(int paramInt)
  {
    this.tcpHandShakeTime = paramInt;
  }
  
  public void setTotalSocketTime(int paramInt)
  {
    this.totalSocketTime = paramInt;
  }
  
  public void setTraceType(TraceType.b paramb)
  {
    this.traceType = paramb;
  }
  
  public void setUserActionId(String paramString)
  {
    this.userActionId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.url).append(" carrier:" + this.carrier).append(" time:" + this.time).append(" statusCode:" + this.statusCode).append(" errorCode:" + this.errorCode).append(" byteSent:" + this.byteSent).append(" bytesReceived:" + this.bytesReceived).append(" appData:" + this.appData).append(" formattedUrlParams:" + this.formattedUrlParams).append(" requestMethodType:" + this.requestMethodType).append(" cdnHeaderName :" + this.cdnHeaderName).append("contentType : " + this.contentType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.api.data.TransactionData
 * JD-Core Version:    0.7.0.1
 */