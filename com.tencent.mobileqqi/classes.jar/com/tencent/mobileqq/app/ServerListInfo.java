package com.tencent.mobileqq.app;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ServerListInfo
  extends JceStruct
{
  public byte bLinkType = 0;
  public byte bProxy = 0;
  public int iPort = 0;
  public String sIP = "";
  
  static
  {
    if (!ServerListInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ServerListInfo()
  {
    setSIP(this.sIP);
    setIPort(this.iPort);
    setBLinkType(this.bLinkType);
    setBProxy(this.bProxy);
  }
  
  public ServerListInfo(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    setSIP(paramString);
    setIPort(paramInt);
    setBLinkType(paramByte1);
    setBProxy(paramByte2);
  }
  
  public String className()
  {
    return "KQQConfig.ServerListInfo";
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
    paramStringBuilder.display(this.sIP, "sIP");
    paramStringBuilder.display(this.iPort, "iPort");
    paramStringBuilder.display(this.bLinkType, "bLinkType");
    paramStringBuilder.display(this.bProxy, "bProxy");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ServerListInfo)paramObject;
    return (JceUtil.equals(this.sIP, paramObject.sIP)) && (JceUtil.equals(this.iPort, paramObject.iPort)) && (JceUtil.equals(this.bLinkType, paramObject.bLinkType)) && (JceUtil.equals(this.bProxy, paramObject.bProxy));
  }
  
  public byte getBLinkType()
  {
    return this.bLinkType;
  }
  
  public byte getBProxy()
  {
    return this.bProxy;
  }
  
  public int getIPort()
  {
    return this.iPort;
  }
  
  public String getSIP()
  {
    return this.sIP;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setSIP(paramJceInputStream.readString(1, true));
    setIPort(paramJceInputStream.read(this.iPort, 2, true));
    setBLinkType(paramJceInputStream.read(this.bLinkType, 3, true));
    setBProxy(paramJceInputStream.read(this.bProxy, 4, true));
  }
  
  public void setBLinkType(byte paramByte)
  {
    this.bLinkType = paramByte;
  }
  
  public void setBProxy(byte paramByte)
  {
    this.bProxy = paramByte;
  }
  
  public void setIPort(int paramInt)
  {
    this.iPort = paramInt;
  }
  
  public void setSIP(String paramString)
  {
    this.sIP = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    paramJceOutputStream.write(this.bProxy, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ServerListInfo
 * JD-Core Version:    0.7.0.1
 */