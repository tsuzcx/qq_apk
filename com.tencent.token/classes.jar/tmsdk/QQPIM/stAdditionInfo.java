package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stAdditionInfo
  extends JceStruct
  implements Cloneable
{
  public int nSimType = 0;
  
  static
  {
    if (!stAdditionInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stAdditionInfo() {}
  
  public stAdditionInfo(int paramInt)
  {
    this.nSimType = paramInt;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.stAdditionInfo";
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
    if (paramObject == null) {
      return false;
    }
    paramObject = (stAdditionInfo)paramObject;
    return JceUtil.equals(this.nSimType, paramObject.nSimType);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.stAdditionInfo";
  }
  
  public int getNSimType()
  {
    return this.nSimType;
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
    this.nSimType = paramJceInputStream.read(this.nSimType, 0, false);
  }
  
  public void setNSimType(int paramInt)
  {
    this.nSimType = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nSimType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.stAdditionInfo
 * JD-Core Version:    0.7.0.1
 */