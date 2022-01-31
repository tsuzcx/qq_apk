package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class PushRegisterInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_pushIds;
  public byte bKikPC = 0;
  public byte bKikWeak = 0;
  public int iStatus = 0;
  public ArrayList pushIds = null;
  public long timeStamp = 0L;
  public String uin = "";
  
  static
  {
    if (!PushRegisterInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushRegisterInfo()
  {
    setUin(this.uin);
    setPushIds(this.pushIds);
    setIStatus(this.iStatus);
    setBKikPC(this.bKikPC);
    setBKikWeak(this.bKikWeak);
    setTimeStamp(this.timeStamp);
  }
  
  public PushRegisterInfo(String paramString, ArrayList paramArrayList, int paramInt, byte paramByte1, byte paramByte2, long paramLong)
  {
    setUin(paramString);
    setPushIds(paramArrayList);
    setIStatus(paramInt);
    setBKikPC(paramByte1);
    setBKikWeak(paramByte2);
    setTimeStamp(paramLong);
  }
  
  public String className()
  {
    return "clientPushInfo.PushRegisterInfo";
  }
  
  public Object clone()
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.uin, "uin");
    paramStringBuilder.display(this.pushIds, "pushIds");
    paramStringBuilder.display(this.iStatus, "iStatus");
    paramStringBuilder.display(this.bKikPC, "bKikPC");
    paramStringBuilder.display(this.bKikWeak, "bKikWeak");
    paramStringBuilder.display(this.timeStamp, "timeStamp");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (PushRegisterInfo)paramObject;
    } while ((!JceUtil.equals(this.uin, paramObject.uin)) || (!JceUtil.equals(this.pushIds, paramObject.pushIds)) || (!JceUtil.equals(this.iStatus, paramObject.iStatus)) || (!JceUtil.equals(this.bKikPC, paramObject.bKikPC)) || (!JceUtil.equals(this.bKikWeak, paramObject.bKikWeak)) || (!JceUtil.equals(this.timeStamp, paramObject.timeStamp)));
    return true;
  }
  
  public String fullClassName()
  {
    return "clientPushInfo.PushRegisterInfo";
  }
  
  public byte getBKikPC()
  {
    return this.bKikPC;
  }
  
  public byte getBKikWeak()
  {
    return this.bKikWeak;
  }
  
  public int getIStatus()
  {
    return this.iStatus;
  }
  
  public ArrayList getPushIds()
  {
    return this.pushIds;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
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
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setUin(paramJceInputStream.readString(1, true));
    if (cache_pushIds == null)
    {
      cache_pushIds = new ArrayList();
      cache_pushIds.add(Long.valueOf(0L));
    }
    setPushIds((ArrayList)paramJceInputStream.read(cache_pushIds, 2, true));
    setIStatus(paramJceInputStream.read(this.iStatus, 3, true));
    setBKikPC(paramJceInputStream.read(this.bKikPC, 4, true));
    setBKikWeak(paramJceInputStream.read(this.bKikWeak, 5, true));
    setTimeStamp(paramJceInputStream.read(this.timeStamp, 6, true));
  }
  
  public void setBKikPC(byte paramByte)
  {
    this.bKikPC = paramByte;
  }
  
  public void setBKikWeak(byte paramByte)
  {
    this.bKikWeak = paramByte;
  }
  
  public void setIStatus(int paramInt)
  {
    this.iStatus = paramInt;
  }
  
  public void setPushIds(ArrayList paramArrayList)
  {
    this.pushIds = paramArrayList;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.pushIds, 2);
    paramJceOutputStream.write(this.iStatus, 3);
    paramJceOutputStream.write(this.bKikPC, 4);
    paramJceOutputStream.write(this.bKikWeak, 5);
    paramJceOutputStream.write(this.timeStamp, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.PushRegisterInfo
 * JD-Core Version:    0.7.0.1
 */