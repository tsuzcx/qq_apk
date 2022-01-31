package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class AppChannel
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecText;
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
  public short textAction = 0;
  public long textBeginDate = 0L;
  public long textEndDate = 0L;
  public ArrayList vecText = null;
  
  static
  {
    if (!AppChannel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (AppChannel)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.marketBeginDate, paramObject.marketBeginDate)) || (!JceUtil.equals(this.marketEndDate, paramObject.marketEndDate)) || (!JceUtil.equals(this.marketEventType, paramObject.marketEventType)) || (!JceUtil.equals(this.marketEventURL, paramObject.marketEventURL)) || (!JceUtil.equals(this.serviceDescription, paramObject.serviceDescription)) || (!JceUtil.equals(this.serviceId, paramObject.serviceId)) || (!JceUtil.equals(this.serviceImage, paramObject.serviceImage)) || (!JceUtil.equals(this.serviceName, paramObject.serviceName)) || (!JceUtil.equals(this.serviceOpenType, paramObject.serviceOpenType)) || (!JceUtil.equals(this.servicePV, paramObject.servicePV)) || (!JceUtil.equals(this.serviceType, paramObject.serviceType)) || (!JceUtil.equals(this.serviceURL, paramObject.serviceURL)) || (!JceUtil.equals(this.serviceAD1, paramObject.serviceAD1)) || (!JceUtil.equals(this.serviceAD2, paramObject.serviceAD2)) || (!JceUtil.equals(this.serviceAD3, paramObject.serviceAD3)) || (!JceUtil.equals(this.serviceMaxVersion, paramObject.serviceMaxVersion)) || (!JceUtil.equals(this.serviceMinVersion, paramObject.serviceMinVersion)) || (!JceUtil.equals(this.vecText, paramObject.vecText)) || (!JceUtil.equals(this.textBeginDate, paramObject.textBeginDate)) || (!JceUtil.equals(this.textEndDate, paramObject.textEndDate)) || (!JceUtil.equals(this.textAction, paramObject.textAction)));
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
    if (cache_vecText == null)
    {
      cache_vecText = new ArrayList();
      cache_vecText.add("");
    }
    this.vecText = ((ArrayList)paramJceInputStream.read(cache_vecText, 18, false));
    this.textBeginDate = paramJceInputStream.read(this.textBeginDate, 19, false);
    this.textEndDate = paramJceInputStream.read(this.textEndDate, 20, false);
    this.textAction = paramJceInputStream.read(this.textAction, 21, false);
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
    if (this.vecText != null) {
      paramJceOutputStream.write(this.vecText, 18);
    }
    paramJceOutputStream.write(this.textBeginDate, 19);
    paramJceOutputStream.write(this.textEndDate, 20);
    paramJceOutputStream.write(this.textAction, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.AppChannel
 * JD-Core Version:    0.7.0.1
 */