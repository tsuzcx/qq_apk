package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RetInfo
  extends JceStruct
  implements Cloneable
{
  public String strtime_sec = "";
  public int time = 0;
  
  static
  {
    if (!RetInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RetInfo()
  {
    setTime(this.time);
    setStrtime_sec(this.strtime_sec);
  }
  
  public RetInfo(int paramInt, String paramString)
  {
    setTime(paramInt);
    setStrtime_sec(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RetInfo";
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
      paramObject = (RetInfo)paramObject;
    } while ((!JceUtil.equals(this.time, paramObject.time)) || (!JceUtil.equals(this.strtime_sec, paramObject.strtime_sec)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.RetInfo";
  }
  
  public String getStrtime_sec()
  {
    return this.strtime_sec;
  }
  
  public int getTime()
  {
    return this.time;
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
    setTime(paramJceInputStream.read(this.time, 0, false));
    setStrtime_sec(paramJceInputStream.readString(1, false));
  }
  
  public void setStrtime_sec(String paramString)
  {
    this.strtime_sec = paramString;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    if (this.strtime_sec != null) {
      paramJceOutputStream.write(this.strtime_sec, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RetInfo
 * JD-Core Version:    0.7.0.1
 */