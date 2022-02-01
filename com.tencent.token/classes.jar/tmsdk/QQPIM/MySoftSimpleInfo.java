package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class MySoftSimpleInfo
  extends JceStruct
  implements Cloneable
{
  static SoftSimpleInfo eC;
  public String function = "";
  public int official = 0;
  public int reportFeature = 0;
  public SoftSimpleInfo softSimpleInfo = null;
  public int update = 0;
  
  public MySoftSimpleInfo()
  {
    setSoftSimpleInfo(this.softSimpleInfo);
    setReportFeature(this.reportFeature);
    setOfficial(this.official);
    setUpdate(this.update);
    setFunction(this.function);
  }
  
  public MySoftSimpleInfo(SoftSimpleInfo paramSoftSimpleInfo, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    setSoftSimpleInfo(paramSoftSimpleInfo);
    setReportFeature(paramInt1);
    setOfficial(paramInt2);
    setUpdate(paramInt3);
    setFunction(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.MySoftSimpleInfo";
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
    paramObject = (MySoftSimpleInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.softSimpleInfo, paramObject.softSimpleInfo))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.reportFeature, paramObject.reportFeature))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.official, paramObject.official))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.update, paramObject.update))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.function, paramObject.function)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.MySoftSimpleInfo";
  }
  
  public String getFunction()
  {
    return this.function;
  }
  
  public int getOfficial()
  {
    return this.official;
  }
  
  public int getReportFeature()
  {
    return this.reportFeature;
  }
  
  public SoftSimpleInfo getSoftSimpleInfo()
  {
    return this.softSimpleInfo;
  }
  
  public int getUpdate()
  {
    return this.update;
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
    if (eC == null) {
      eC = new SoftSimpleInfo();
    }
    setSoftSimpleInfo((SoftSimpleInfo)paramJceInputStream.read(eC, 0, true));
    setReportFeature(paramJceInputStream.read(this.reportFeature, 1, false));
    setOfficial(paramJceInputStream.read(this.official, 2, false));
    setUpdate(paramJceInputStream.read(this.update, 3, false));
    setFunction(paramJceInputStream.readString(4, false));
  }
  
  public void setFunction(String paramString)
  {
    this.function = paramString;
  }
  
  public void setOfficial(int paramInt)
  {
    this.official = paramInt;
  }
  
  public void setReportFeature(int paramInt)
  {
    this.reportFeature = paramInt;
  }
  
  public void setSoftSimpleInfo(SoftSimpleInfo paramSoftSimpleInfo)
  {
    this.softSimpleInfo = paramSoftSimpleInfo;
  }
  
  public void setUpdate(int paramInt)
  {
    this.update = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softSimpleInfo, 0);
    paramJceOutputStream.write(this.reportFeature, 1);
    paramJceOutputStream.write(this.official, 2);
    paramJceOutputStream.write(this.update, 3);
    String str = this.function;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.MySoftSimpleInfo
 * JD-Core Version:    0.7.0.1
 */