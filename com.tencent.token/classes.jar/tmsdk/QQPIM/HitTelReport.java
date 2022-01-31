package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class HitTelReport
  extends JceStruct
  implements Cloneable
{
  public int iFileStamp = 0;
  public int iHitTime = 0;
  public int iTelType = 0;
  public String sPhonenum = "";
  
  static
  {
    if (!HitTelReport.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HitTelReport() {}
  
  public HitTelReport(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.sPhonenum = paramString;
    this.iHitTime = paramInt1;
    this.iFileStamp = paramInt2;
    this.iTelType = paramInt3;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.HitTelReport";
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
      paramObject = (HitTelReport)paramObject;
    } while ((!JceUtil.equals(this.sPhonenum, paramObject.sPhonenum)) || (!JceUtil.equals(this.iHitTime, paramObject.iHitTime)) || (!JceUtil.equals(this.iFileStamp, paramObject.iFileStamp)) || (!JceUtil.equals(this.iTelType, paramObject.iTelType)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.HitTelReport";
  }
  
  public int getIFileStamp()
  {
    return this.iFileStamp;
  }
  
  public int getIHitTime()
  {
    return this.iHitTime;
  }
  
  public int getITelType()
  {
    return this.iTelType;
  }
  
  public String getSPhonenum()
  {
    return this.sPhonenum;
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
    this.sPhonenum = paramJceInputStream.readString(0, true);
    this.iHitTime = paramJceInputStream.read(this.iHitTime, 1, true);
    this.iFileStamp = paramJceInputStream.read(this.iFileStamp, 2, true);
    this.iTelType = paramJceInputStream.read(this.iTelType, 3, false);
  }
  
  public void setIFileStamp(int paramInt)
  {
    this.iFileStamp = paramInt;
  }
  
  public void setIHitTime(int paramInt)
  {
    this.iHitTime = paramInt;
  }
  
  public void setITelType(int paramInt)
  {
    this.iTelType = paramInt;
  }
  
  public void setSPhonenum(String paramString)
  {
    this.sPhonenum = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sPhonenum, 0);
    paramJceOutputStream.write(this.iHitTime, 1);
    paramJceOutputStream.write(this.iFileStamp, 2);
    paramJceOutputStream.write(this.iTelType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.HitTelReport
 * JD-Core Version:    0.7.0.1
 */