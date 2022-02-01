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
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (LicenceInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.strsignature, paramObject.strsignature))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strchannel, paramObject.strchannel)) {
        bool1 = true;
      }
    }
    return bool1;
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
    String str = this.strchannel;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.LicenceInfo
 * JD-Core Version:    0.7.0.1
 */