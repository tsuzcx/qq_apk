package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SvcReqRegister
  extends JceStruct
{
  public byte bIsOnline = 0;
  public byte bIsShowOnline = 0;
  public byte bKikPC = 0;
  public byte bKikWeak = 0;
  public byte bOnlinePush = 0;
  public byte cConnType = 0;
  public int iStatus = 11;
  public long lBid = 0L;
  public long lUin = 0L;
  public String sOther = "";
  public long timeStamp = 0L;
  
  static
  {
    if (!SvcReqRegister.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcReqRegister()
  {
    setLUin(this.lUin);
    setLBid(this.lBid);
    setCConnType(this.cConnType);
    setSOther(this.sOther);
    setIStatus(this.iStatus);
    setBOnlinePush(this.bOnlinePush);
    setBIsOnline(this.bIsOnline);
    setBIsShowOnline(this.bIsShowOnline);
    setBKikPC(this.bKikPC);
    setBKikWeak(this.bKikWeak);
    setTimeStamp(this.timeStamp);
  }
  
  public SvcReqRegister(long paramLong1, long paramLong2, byte paramByte1, String paramString, int paramInt, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, long paramLong3)
  {
    setLUin(paramLong1);
    setLBid(paramLong2);
    setCConnType(paramByte1);
    setSOther(paramString);
    setIStatus(paramInt);
    setBOnlinePush(paramByte2);
    setBIsOnline(paramByte3);
    setBIsShowOnline(paramByte4);
    setBKikPC(paramByte5);
    setBKikWeak(paramByte6);
    setTimeStamp(paramLong3);
  }
  
  public String className()
  {
    return "com.tencent.sc.qzonepush.QQService.SvcReqRegister";
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
    paramStringBuilder.display(this.lUin, "lUin");
    paramStringBuilder.display(this.lBid, "lBid");
    paramStringBuilder.display(this.cConnType, "cConnType");
    paramStringBuilder.display(this.sOther, "sOther");
    paramStringBuilder.display(this.iStatus, "iStatus");
    paramStringBuilder.display(this.bOnlinePush, "bOnlinePush");
    paramStringBuilder.display(this.bIsOnline, "bIsOnline");
    paramStringBuilder.display(this.bIsShowOnline, "bIsShowOnline");
    paramStringBuilder.display(this.bKikPC, "bKikPC");
    paramStringBuilder.display(this.bKikWeak, "bKikWeak");
    paramStringBuilder.display(this.timeStamp, "timeStamp");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcReqRegister)paramObject;
    return (paramObject != null) && (JceUtil.equals(this.lUin, paramObject.lUin)) && (JceUtil.equals(this.lBid, paramObject.lBid)) && (JceUtil.equals(this.cConnType, paramObject.cConnType)) && (JceUtil.equals(this.sOther, paramObject.sOther)) && (JceUtil.equals(this.iStatus, paramObject.iStatus)) && (JceUtil.equals(this.bOnlinePush, paramObject.bOnlinePush)) && (JceUtil.equals(this.bIsOnline, paramObject.bIsOnline)) && (JceUtil.equals(this.bIsShowOnline, paramObject.bIsShowOnline)) && (JceUtil.equals(this.bKikPC, paramObject.bKikPC)) && (JceUtil.equals(this.bKikWeak, paramObject.bKikWeak)) && (JceUtil.equals(this.timeStamp, paramObject.timeStamp));
  }
  
  public byte getBIsOnline()
  {
    return this.bIsOnline;
  }
  
  public byte getBIsShowOnline()
  {
    return this.bIsShowOnline;
  }
  
  public byte getBKikPC()
  {
    return this.bKikPC;
  }
  
  public byte getBKikWeak()
  {
    return this.bKikWeak;
  }
  
  public byte getBOnlinePush()
  {
    return this.bOnlinePush;
  }
  
  public byte getCConnType()
  {
    return this.cConnType;
  }
  
  public int getIStatus()
  {
    return this.iStatus;
  }
  
  public long getLBid()
  {
    return this.lBid;
  }
  
  public long getLUin()
  {
    return this.lUin;
  }
  
  public String getSOther()
  {
    return this.sOther;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setLUin(paramJceInputStream.read(this.lUin, 0, true));
    setLBid(paramJceInputStream.read(this.lBid, 1, true));
    setCConnType(paramJceInputStream.read(this.cConnType, 2, true));
    setSOther(paramJceInputStream.readString(3, true));
    setIStatus(paramJceInputStream.read(this.iStatus, 4, false));
    setBOnlinePush(paramJceInputStream.read(this.bOnlinePush, 5, false));
    setBIsOnline(paramJceInputStream.read(this.bIsOnline, 6, false));
    setBIsShowOnline(paramJceInputStream.read(this.bIsShowOnline, 7, false));
    setBKikPC(paramJceInputStream.read(this.bKikPC, 8, false));
    setBKikWeak(paramJceInputStream.read(this.bKikWeak, 9, false));
    setTimeStamp(paramJceInputStream.read(this.timeStamp, 10, false));
  }
  
  public void setBIsOnline(byte paramByte)
  {
    this.bIsOnline = paramByte;
  }
  
  public void setBIsShowOnline(byte paramByte)
  {
    this.bIsShowOnline = paramByte;
  }
  
  public void setBKikPC(byte paramByte)
  {
    this.bKikPC = paramByte;
  }
  
  public void setBKikWeak(byte paramByte)
  {
    this.bKikWeak = paramByte;
  }
  
  public void setBOnlinePush(byte paramByte)
  {
    this.bOnlinePush = paramByte;
  }
  
  public void setCConnType(byte paramByte)
  {
    this.cConnType = paramByte;
  }
  
  public void setIStatus(int paramInt)
  {
    this.iStatus = paramInt;
  }
  
  public void setLBid(long paramLong)
  {
    this.lBid = paramLong;
  }
  
  public void setLUin(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void setSOther(String paramString)
  {
    this.sOther = paramString;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cConnType, 2);
    paramJceOutputStream.write(this.sOther, 3);
    paramJceOutputStream.write(this.iStatus, 4);
    paramJceOutputStream.write(this.bOnlinePush, 5);
    paramJceOutputStream.write(this.bIsOnline, 6);
    paramJceOutputStream.write(this.bIsShowOnline, 7);
    paramJceOutputStream.write(this.bKikPC, 8);
    paramJceOutputStream.write(this.bKikWeak, 9);
    paramJceOutputStream.write(this.timeStamp, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.sc.qzonepush.QQService.SvcReqRegister
 * JD-Core Version:    0.7.0.1
 */