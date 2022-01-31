package Wallet;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AppChannel
  extends JceStruct
  implements Cloneable
{
  public int id = 0;
  public long marketBeginDate = 0L;
  public long marketEndDate = 0L;
  public int marketEventType = 0;
  public String marketEventURL = "";
  public String serviceAD1 = "";
  public String serviceAD2 = "";
  public String serviceAD3 = "";
  public String serviceDescription = "";
  public String serviceId = "";
  public String serviceImage = "";
  public String serviceMaxVersion = "";
  public String serviceMinVersion = "";
  public String serviceName = "";
  public String serviceOpenType = "";
  public String servicePV = "";
  public int serviceType = 0;
  public String serviceURL = "";
  
  static
  {
    if (!AppChannel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AppChannel() {}
  
  public AppChannel(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt3, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this.id = paramInt1;
    this.marketBeginDate = paramLong1;
    this.marketEndDate = paramLong2;
    this.marketEventType = paramInt2;
    this.marketEventURL = paramString1;
    this.serviceDescription = paramString2;
    this.serviceId = paramString3;
    this.serviceImage = paramString4;
    this.serviceName = paramString5;
    this.serviceOpenType = paramString6;
    this.servicePV = paramString7;
    this.serviceType = paramInt3;
    this.serviceURL = paramString8;
    this.serviceAD1 = paramString9;
    this.serviceAD2 = paramString10;
    this.serviceAD3 = paramString11;
    this.serviceMaxVersion = paramString12;
    this.serviceMinVersion = paramString13;
  }
  
  public String className()
  {
    return "Wallet.AppChannel";
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
    paramStringBuilder.display(this.id, "id");
    paramStringBuilder.display(this.marketBeginDate, "marketBeginDate");
    paramStringBuilder.display(this.marketEndDate, "marketEndDate");
    paramStringBuilder.display(this.marketEventType, "marketEventType");
    paramStringBuilder.display(this.marketEventURL, "marketEventURL");
    paramStringBuilder.display(this.serviceDescription, "serviceDescription");
    paramStringBuilder.display(this.serviceId, "serviceId");
    paramStringBuilder.display(this.serviceImage, "serviceImage");
    paramStringBuilder.display(this.serviceName, "serviceName");
    paramStringBuilder.display(this.serviceOpenType, "serviceOpenType");
    paramStringBuilder.display(this.servicePV, "servicePV");
    paramStringBuilder.display(this.serviceType, "serviceType");
    paramStringBuilder.display(this.serviceURL, "serviceURL");
    paramStringBuilder.display(this.serviceAD1, "serviceAD1");
    paramStringBuilder.display(this.serviceAD2, "serviceAD2");
    paramStringBuilder.display(this.serviceAD3, "serviceAD3");
    paramStringBuilder.display(this.serviceMaxVersion, "serviceMaxVersion");
    paramStringBuilder.display(this.serviceMinVersion, "serviceMinVersion");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.id, true);
    paramStringBuilder.displaySimple(this.marketBeginDate, true);
    paramStringBuilder.displaySimple(this.marketEndDate, true);
    paramStringBuilder.displaySimple(this.marketEventType, true);
    paramStringBuilder.displaySimple(this.marketEventURL, true);
    paramStringBuilder.displaySimple(this.serviceDescription, true);
    paramStringBuilder.displaySimple(this.serviceId, true);
    paramStringBuilder.displaySimple(this.serviceImage, true);
    paramStringBuilder.displaySimple(this.serviceName, true);
    paramStringBuilder.displaySimple(this.serviceOpenType, true);
    paramStringBuilder.displaySimple(this.servicePV, true);
    paramStringBuilder.displaySimple(this.serviceType, true);
    paramStringBuilder.displaySimple(this.serviceURL, true);
    paramStringBuilder.displaySimple(this.serviceAD1, true);
    paramStringBuilder.displaySimple(this.serviceAD2, true);
    paramStringBuilder.displaySimple(this.serviceAD3, true);
    paramStringBuilder.displaySimple(this.serviceMaxVersion, true);
    paramStringBuilder.displaySimple(this.serviceMinVersion, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (AppChannel)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.marketBeginDate, paramObject.marketBeginDate)) || (!JceUtil.equals(this.marketEndDate, paramObject.marketEndDate)) || (!JceUtil.equals(this.marketEventType, paramObject.marketEventType)) || (!JceUtil.equals(this.marketEventURL, paramObject.marketEventURL)) || (!JceUtil.equals(this.serviceDescription, paramObject.serviceDescription)) || (!JceUtil.equals(this.serviceId, paramObject.serviceId)) || (!JceUtil.equals(this.serviceImage, paramObject.serviceImage)) || (!JceUtil.equals(this.serviceName, paramObject.serviceName)) || (!JceUtil.equals(this.serviceOpenType, paramObject.serviceOpenType)) || (!JceUtil.equals(this.servicePV, paramObject.servicePV)) || (!JceUtil.equals(this.serviceType, paramObject.serviceType)) || (!JceUtil.equals(this.serviceURL, paramObject.serviceURL)) || (!JceUtil.equals(this.serviceAD1, paramObject.serviceAD1)) || (!JceUtil.equals(this.serviceAD2, paramObject.serviceAD2)) || (!JceUtil.equals(this.serviceAD3, paramObject.serviceAD3)) || (!JceUtil.equals(this.serviceMaxVersion, paramObject.serviceMaxVersion)) || (!JceUtil.equals(this.serviceMinVersion, paramObject.serviceMinVersion)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.AppChannel";
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
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.marketBeginDate = paramJceInputStream.read(this.marketBeginDate, 1, true);
    this.marketEndDate = paramJceInputStream.read(this.marketEndDate, 2, true);
    this.marketEventType = paramJceInputStream.read(this.marketEventType, 3, true);
    this.marketEventURL = paramJceInputStream.readString(4, true);
    this.serviceDescription = paramJceInputStream.readString(5, true);
    this.serviceId = paramJceInputStream.readString(6, true);
    this.serviceImage = paramJceInputStream.readString(7, true);
    this.serviceName = paramJceInputStream.readString(8, true);
    this.serviceOpenType = paramJceInputStream.readString(9, true);
    this.servicePV = paramJceInputStream.readString(10, true);
    this.serviceType = paramJceInputStream.read(this.serviceType, 11, true);
    this.serviceURL = paramJceInputStream.readString(12, true);
    this.serviceAD1 = paramJceInputStream.readString(13, false);
    this.serviceAD2 = paramJceInputStream.readString(14, false);
    this.serviceAD3 = paramJceInputStream.readString(15, false);
    this.serviceMaxVersion = paramJceInputStream.readString(16, false);
    this.serviceMinVersion = paramJceInputStream.readString(17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.marketBeginDate, 1);
    paramJceOutputStream.write(this.marketEndDate, 2);
    paramJceOutputStream.write(this.marketEventType, 3);
    paramJceOutputStream.write(this.marketEventURL, 4);
    paramJceOutputStream.write(this.serviceDescription, 5);
    paramJceOutputStream.write(this.serviceId, 6);
    paramJceOutputStream.write(this.serviceImage, 7);
    paramJceOutputStream.write(this.serviceName, 8);
    paramJceOutputStream.write(this.serviceOpenType, 9);
    paramJceOutputStream.write(this.servicePV, 10);
    paramJceOutputStream.write(this.serviceType, 11);
    paramJceOutputStream.write(this.serviceURL, 12);
    if (this.serviceAD1 != null) {
      paramJceOutputStream.write(this.serviceAD1, 13);
    }
    if (this.serviceAD2 != null) {
      paramJceOutputStream.write(this.serviceAD2, 14);
    }
    if (this.serviceAD3 != null) {
      paramJceOutputStream.write(this.serviceAD3, 15);
    }
    if (this.serviceMaxVersion != null) {
      paramJceOutputStream.write(this.serviceMaxVersion, 16);
    }
    if (this.serviceMinVersion != null) {
      paramJceOutputStream.write(this.serviceMinVersion, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     Wallet.AppChannel
 * JD-Core Version:    0.7.0.1
 */