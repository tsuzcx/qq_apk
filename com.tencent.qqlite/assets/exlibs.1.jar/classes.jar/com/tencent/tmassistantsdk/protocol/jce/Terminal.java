package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Terminal
  extends JceStruct
  implements Cloneable
{
  public String androidId = "";
  public String androidIdSdCard = "";
  public String imei = "";
  public String imsi = "";
  public String macAdress = "";
  
  static
  {
    if (!Terminal.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Terminal() {}
  
  public Terminal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.imei = paramString1;
    this.macAdress = paramString2;
    this.androidId = paramString3;
    this.androidIdSdCard = paramString4;
    this.imsi = paramString5;
  }
  
  public final String className()
  {
    return "jce.Terminal";
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
    paramStringBuilder.display(this.imei, "imei");
    paramStringBuilder.display(this.macAdress, "macAdress");
    paramStringBuilder.display(this.androidId, "androidId");
    paramStringBuilder.display(this.androidIdSdCard, "androidIdSdCard");
    paramStringBuilder.display(this.imsi, "imsi");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.imei, true);
    paramStringBuilder.displaySimple(this.macAdress, true);
    paramStringBuilder.displaySimple(this.androidId, true);
    paramStringBuilder.displaySimple(this.androidIdSdCard, true);
    paramStringBuilder.displaySimple(this.imsi, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Terminal)paramObject;
    } while ((!JceUtil.equals(this.imei, paramObject.imei)) || (!JceUtil.equals(this.macAdress, paramObject.macAdress)) || (!JceUtil.equals(this.androidId, paramObject.androidId)) || (!JceUtil.equals(this.androidIdSdCard, paramObject.androidIdSdCard)) || (!JceUtil.equals(this.imsi, paramObject.imsi)));
    return true;
  }
  
  public final String fullClassName()
  {
    return "com.tencent.tmassistantsdk.protocol.jce.Terminal";
  }
  
  public final String getAndroidId()
  {
    return this.androidId;
  }
  
  public final String getAndroidIdSdCard()
  {
    return this.androidIdSdCard;
  }
  
  public final String getImei()
  {
    return this.imei;
  }
  
  public final String getImsi()
  {
    return this.imsi;
  }
  
  public final String getMacAdress()
  {
    return this.macAdress;
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
    this.imei = paramJceInputStream.readString(0, false);
    this.macAdress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.androidIdSdCard = paramJceInputStream.readString(3, false);
    this.imsi = paramJceInputStream.readString(4, false);
  }
  
  public final void setAndroidId(String paramString)
  {
    this.androidId = paramString;
  }
  
  public final void setAndroidIdSdCard(String paramString)
  {
    this.androidIdSdCard = paramString;
  }
  
  public final void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public final void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public final void setMacAdress(String paramString)
  {
    this.macAdress = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.macAdress != null) {
      paramJceOutputStream.write(this.macAdress, 1);
    }
    if (this.androidId != null) {
      paramJceOutputStream.write(this.androidId, 2);
    }
    if (this.androidIdSdCard != null) {
      paramJceOutputStream.write(this.androidIdSdCard, 3);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */