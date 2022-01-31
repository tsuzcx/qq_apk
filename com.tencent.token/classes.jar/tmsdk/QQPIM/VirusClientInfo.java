package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VirusClientInfo
  extends JceStruct
  implements Cloneable
{
  public int engine_version = 2;
  public int timestamp = 0;
  public int updatetype = 0;
  public int version = 0;
  
  static
  {
    if (!VirusClientInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public VirusClientInfo() {}
  
  public VirusClientInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.timestamp = paramInt1;
    this.version = paramInt2;
    this.engine_version = paramInt3;
    this.updatetype = paramInt4;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.VirusClientInfo";
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
      paramObject = (VirusClientInfo)paramObject;
    } while ((!JceUtil.equals(this.timestamp, paramObject.timestamp)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.engine_version, paramObject.engine_version)) || (!JceUtil.equals(this.updatetype, paramObject.updatetype)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.VirusClientInfo";
  }
  
  public int getEngine_version()
  {
    return this.engine_version;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getUpdatetype()
  {
    return this.updatetype;
  }
  
  public int getVersion()
  {
    return this.version;
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
    this.timestamp = paramJceInputStream.read(this.timestamp, 0, true);
    this.version = paramJceInputStream.read(this.version, 1, true);
    this.engine_version = paramJceInputStream.read(this.engine_version, 2, false);
    this.updatetype = paramJceInputStream.read(this.updatetype, 3, false);
  }
  
  public void setEngine_version(int paramInt)
  {
    this.engine_version = paramInt;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.timestamp = paramInt;
  }
  
  public void setUpdatetype(int paramInt)
  {
    this.updatetype = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.timestamp, 0);
    paramJceOutputStream.write(this.version, 1);
    paramJceOutputStream.write(this.engine_version, 2);
    paramJceOutputStream.write(this.updatetype, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.VirusClientInfo
 * JD-Core Version:    0.7.0.1
 */