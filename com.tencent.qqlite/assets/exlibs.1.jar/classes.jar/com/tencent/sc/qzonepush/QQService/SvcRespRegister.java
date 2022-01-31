package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SvcRespRegister
  extends JceStruct
{
  public byte bLogQQ = 0;
  public byte bNeedKik = 0;
  public byte bUpdateFlag = 0;
  public byte cReplyCode = 0;
  public long lBid = 0L;
  public long lServerTime = 0L;
  public long lUin = 0L;
  public String strResult = "";
  public long timeStamp = 0L;
  
  static
  {
    if (!SvcRespRegister.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcRespRegister()
  {
    setLUin(this.lUin);
    setLBid(this.lBid);
    setCReplyCode(this.cReplyCode);
    setStrResult(this.strResult);
    setLServerTime(this.lServerTime);
    setBLogQQ(this.bLogQQ);
    setBNeedKik(this.bNeedKik);
    setBUpdateFlag(this.bUpdateFlag);
    setTimeStamp(this.timeStamp);
  }
  
  public SvcRespRegister(long paramLong1, long paramLong2, byte paramByte1, String paramString, long paramLong3, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong4)
  {
    setLUin(paramLong1);
    setLBid(paramLong2);
    setCReplyCode(paramByte1);
    setStrResult(paramString);
    setLServerTime(paramLong3);
    setBLogQQ(paramByte2);
    setBNeedKik(paramByte3);
    setBUpdateFlag(paramByte4);
    setTimeStamp(paramLong4);
  }
  
  public String className()
  {
    return "com.tencent.sc.qzonepush.QQService.SvcRespRegister";
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
    paramStringBuilder.display(this.cReplyCode, "cReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
    paramStringBuilder.display(this.lServerTime, "lServerTime");
    paramStringBuilder.display(this.bLogQQ, "bLogQQ");
    paramStringBuilder.display(this.bNeedKik, "bNeedKik");
    paramStringBuilder.display(this.bUpdateFlag, "bUpdateFlag");
    paramStringBuilder.display(this.timeStamp, "timeStamp");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SvcRespRegister)paramObject;
    } while ((!JceUtil.equals(this.lUin, paramObject.lUin)) || (!JceUtil.equals(this.lBid, paramObject.lBid)) || (!JceUtil.equals(this.cReplyCode, paramObject.cReplyCode)) || (!JceUtil.equals(this.strResult, paramObject.strResult)) || (!JceUtil.equals(this.lServerTime, paramObject.lServerTime)) || (!JceUtil.equals(this.bLogQQ, paramObject.bLogQQ)) || (!JceUtil.equals(this.bNeedKik, paramObject.bNeedKik)) || (!JceUtil.equals(this.bUpdateFlag, paramObject.bUpdateFlag)) || (!JceUtil.equals(this.timeStamp, paramObject.timeStamp)));
    return true;
  }
  
  public byte getBLogQQ()
  {
    return this.bLogQQ;
  }
  
  public byte getBNeedKik()
  {
    return this.bNeedKik;
  }
  
  public byte getBUpdateFlag()
  {
    return this.bUpdateFlag;
  }
  
  public byte getCReplyCode()
  {
    return this.cReplyCode;
  }
  
  public long getLBid()
  {
    return this.lBid;
  }
  
  public long getLServerTime()
  {
    return this.lServerTime;
  }
  
  public long getLUin()
  {
    return this.lUin;
  }
  
  public String getStrResult()
  {
    return this.strResult;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setLUin(paramJceInputStream.read(this.lUin, 0, true));
    setLBid(paramJceInputStream.read(this.lBid, 1, true));
    setCReplyCode(paramJceInputStream.read(this.cReplyCode, 2, true));
    setStrResult(paramJceInputStream.readString(3, true));
    setLServerTime(paramJceInputStream.read(this.lServerTime, 4, false));
    setBLogQQ(paramJceInputStream.read(this.bLogQQ, 5, false));
    setBNeedKik(paramJceInputStream.read(this.bNeedKik, 6, false));
    setBUpdateFlag(paramJceInputStream.read(this.bUpdateFlag, 7, false));
    setTimeStamp(paramJceInputStream.read(this.timeStamp, 8, false));
  }
  
  public void setBLogQQ(byte paramByte)
  {
    this.bLogQQ = paramByte;
  }
  
  public void setBNeedKik(byte paramByte)
  {
    this.bNeedKik = paramByte;
  }
  
  public void setBUpdateFlag(byte paramByte)
  {
    this.bUpdateFlag = paramByte;
  }
  
  public void setCReplyCode(byte paramByte)
  {
    this.cReplyCode = paramByte;
  }
  
  public void setLBid(long paramLong)
  {
    this.lBid = paramLong;
  }
  
  public void setLServerTime(long paramLong)
  {
    this.lServerTime = paramLong;
  }
  
  public void setLUin(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void setStrResult(String paramString)
  {
    this.strResult = paramString;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
    paramJceOutputStream.write(this.lServerTime, 4);
    paramJceOutputStream.write(this.bLogQQ, 5);
    paramJceOutputStream.write(this.bNeedKik, 6);
    paramJceOutputStream.write(this.bUpdateFlag, 7);
    paramJceOutputStream.write(this.timeStamp, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.sc.qzonepush.QQService.SvcRespRegister
 * JD-Core Version:    0.7.0.1
 */