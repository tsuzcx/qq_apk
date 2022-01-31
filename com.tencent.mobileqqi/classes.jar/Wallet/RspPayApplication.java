package Wallet;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspPayApplication
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecADBanner;
  static ArrayList cache_vecAppChannel;
  public String backInfo = "";
  public int isDisAddress = 0;
  public int isDisRecords = 0;
  public String msg = "";
  public int pollInterval = 0;
  public int refreshPeriod = 0;
  public int ret = 0;
  public ArrayList vecADBanner = null;
  public ArrayList vecAppChannel = null;
  
  static
  {
    if (!RspPayApplication.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspPayApplication() {}
  
  public RspPayApplication(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString2, int paramInt5)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.refreshPeriod = paramInt2;
    this.isDisRecords = paramInt3;
    this.pollInterval = paramInt4;
    this.vecAppChannel = paramArrayList1;
    this.vecADBanner = paramArrayList2;
    this.backInfo = paramString2;
    this.isDisAddress = paramInt5;
  }
  
  public String className()
  {
    return "Wallet.RspPayApplication";
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
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.msg, "msg");
    paramStringBuilder.display(this.refreshPeriod, "refreshPeriod");
    paramStringBuilder.display(this.isDisRecords, "isDisRecords");
    paramStringBuilder.display(this.pollInterval, "pollInterval");
    paramStringBuilder.display(this.vecAppChannel, "vecAppChannel");
    paramStringBuilder.display(this.vecADBanner, "vecADBanner");
    paramStringBuilder.display(this.backInfo, "backInfo");
    paramStringBuilder.display(this.isDisAddress, "isDisAddress");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.msg, true);
    paramStringBuilder.displaySimple(this.refreshPeriod, true);
    paramStringBuilder.displaySimple(this.isDisRecords, true);
    paramStringBuilder.displaySimple(this.pollInterval, true);
    paramStringBuilder.displaySimple(this.vecAppChannel, true);
    paramStringBuilder.displaySimple(this.vecADBanner, true);
    paramStringBuilder.displaySimple(this.backInfo, true);
    paramStringBuilder.displaySimple(this.isDisAddress, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RspPayApplication)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.msg, paramObject.msg)) || (!JceUtil.equals(this.refreshPeriod, paramObject.refreshPeriod)) || (!JceUtil.equals(this.isDisRecords, paramObject.isDisRecords)) || (!JceUtil.equals(this.pollInterval, paramObject.pollInterval)) || (!JceUtil.equals(this.vecAppChannel, paramObject.vecAppChannel)) || (!JceUtil.equals(this.vecADBanner, paramObject.vecADBanner)) || (!JceUtil.equals(this.backInfo, paramObject.backInfo)) || (!JceUtil.equals(this.isDisAddress, paramObject.isDisAddress)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.RspPayApplication";
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
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.refreshPeriod = paramJceInputStream.read(this.refreshPeriod, 2, true);
    this.isDisRecords = paramJceInputStream.read(this.isDisRecords, 3, true);
    this.pollInterval = paramJceInputStream.read(this.pollInterval, 4, true);
    AppChannel localAppChannel;
    if (cache_vecAppChannel == null)
    {
      cache_vecAppChannel = new ArrayList();
      localAppChannel = new AppChannel();
      cache_vecAppChannel.add(localAppChannel);
    }
    this.vecAppChannel = ((ArrayList)paramJceInputStream.read(cache_vecAppChannel, 5, true));
    if (cache_vecADBanner == null)
    {
      cache_vecADBanner = new ArrayList();
      localAppChannel = new AppChannel();
      cache_vecADBanner.add(localAppChannel);
    }
    this.vecADBanner = ((ArrayList)paramJceInputStream.read(cache_vecADBanner, 6, true));
    this.backInfo = paramJceInputStream.readString(7, true);
    this.isDisAddress = paramJceInputStream.read(this.isDisAddress, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.refreshPeriod, 2);
    paramJceOutputStream.write(this.isDisRecords, 3);
    paramJceOutputStream.write(this.pollInterval, 4);
    paramJceOutputStream.write(this.vecAppChannel, 5);
    paramJceOutputStream.write(this.vecADBanner, 6);
    paramJceOutputStream.write(this.backInfo, 7);
    paramJceOutputStream.write(this.isDisAddress, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     Wallet.RspPayApplication
 * JD-Core Version:    0.7.0.1
 */