package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReportLogRequest
  extends JceStruct
  implements Cloneable
{
  private static byte[] cache_logData;
  public String hostAppPackageName = "";
  public int hostAppVersion = 0;
  public String hostUserId = "";
  public byte[] logData = null;
  public int logType = 0;
  
  static
  {
    if (!ReportLogRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReportLogRequest() {}
  
  public ReportLogRequest(int paramInt1, byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt2)
  {
    this.logType = paramInt1;
    this.logData = paramArrayOfByte;
    this.hostUserId = paramString1;
    this.hostAppPackageName = paramString2;
    this.hostAppVersion = paramInt2;
  }
  
  public final String className()
  {
    return "jce.ReportLogRequest";
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.logType, "logType");
    paramStringBuilder.display(this.logData, "logData");
    paramStringBuilder.display(this.hostUserId, "hostUserId");
    paramStringBuilder.display(this.hostAppPackageName, "hostAppPackageName");
    paramStringBuilder.display(this.hostAppVersion, "hostAppVersion");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.logType, true);
    paramStringBuilder.displaySimple(this.logData, true);
    paramStringBuilder.displaySimple(this.hostUserId, true);
    paramStringBuilder.displaySimple(this.hostAppPackageName, true);
    paramStringBuilder.displaySimple(this.hostAppVersion, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReportLogRequest)paramObject;
    } while ((!JceUtil.equals(this.logType, paramObject.logType)) || (!JceUtil.equals(this.logData, paramObject.logData)) || (!JceUtil.equals(this.hostUserId, paramObject.hostUserId)) || (!JceUtil.equals(this.hostAppPackageName, paramObject.hostAppPackageName)) || (!JceUtil.equals(this.hostAppVersion, paramObject.hostAppVersion)));
    return true;
  }
  
  public final String fullClassName()
  {
    return "com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest";
  }
  
  public final String getHostAppPackageName()
  {
    return this.hostAppPackageName;
  }
  
  public final int getHostAppVersion()
  {
    return this.hostAppVersion;
  }
  
  public final String getHostUserId()
  {
    return this.hostUserId;
  }
  
  public final byte[] getLogData()
  {
    return this.logData;
  }
  
  public final int getLogType()
  {
    return this.logType;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.logType = paramJceInputStream.read(this.logType, 0, false);
    if (cache_logData == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_logData = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.logData = ((byte[])paramJceInputStream.read(cache_logData, 1, false));
    this.hostUserId = paramJceInputStream.readString(2, false);
    this.hostAppPackageName = paramJceInputStream.readString(3, false);
    this.hostAppVersion = paramJceInputStream.read(this.hostAppVersion, 4, false);
  }
  
  public final void setHostAppPackageName(String paramString)
  {
    this.hostAppPackageName = paramString;
  }
  
  public final void setHostAppVersion(int paramInt)
  {
    this.hostAppVersion = paramInt;
  }
  
  public final void setHostUserId(String paramString)
  {
    this.hostUserId = paramString;
  }
  
  public final void setLogData(byte[] paramArrayOfByte)
  {
    this.logData = paramArrayOfByte;
  }
  
  public final void setLogType(int paramInt)
  {
    this.logType = paramInt;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logType, 0);
    if (this.logData != null) {
      paramJceOutputStream.write(this.logData, 1);
    }
    if (this.hostUserId != null) {
      paramJceOutputStream.write(this.hostUserId, 2);
    }
    if (this.hostAppPackageName != null) {
      paramJceOutputStream.write(this.hostAppPackageName, 3);
    }
    paramJceOutputStream.write(this.hostAppVersion, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest
 * JD-Core Version:    0.7.0.1
 */