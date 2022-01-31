package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class LicenceInfo
  extends JceStruct
  implements Cloneable
{
  public String strchannel = "";
  public String strsignature = "";
  
  static
  {
    if (!LicenceInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public LicenceInfo()
  {
    setStrsignature(this.strsignature);
    setStrchannel(this.strchannel);
  }
  
  public LicenceInfo(String paramString1, String paramString2)
  {
    setStrsignature(paramString1);
    setStrchannel(paramString2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.LicenceInfo";
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
      paramObject = (LicenceInfo)paramObject;
    } while ((!JceUtil.equals(this.strsignature, paramObject.strsignature)) || (!JceUtil.equals(this.strchannel, paramObject.strchannel)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.LicenceInfo";
  }
  
  public String getStrchannel()
  {
    return this.strchannel;
  }
  
  public String getStrsignature()
  {
    return this.strsignature;
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
    setStrsignature(paramJceInputStream.readString(0, true));
    setStrchannel(paramJceInputStream.readString(1, false));
  }
  
  public void setStrchannel(String paramString)
  {
    this.strchannel = paramString;
  }
  
  public void setStrsignature(String paramString)
  {
    this.strsignature = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strsignature, 0);
    if (this.strchannel != null) {
      paramJceOutputStream.write(this.strchannel, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.LicenceInfo
 * JD-Core Version:    0.7.0.1
 */