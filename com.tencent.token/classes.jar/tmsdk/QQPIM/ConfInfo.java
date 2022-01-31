package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ConfInfo
  extends JceStruct
  implements Cloneable
{
  public String checksum = "";
  public String filename = "";
  public int gettype = 0;
  public int pfutimestamp = 0;
  public int timestamp = 0;
  public int version = 0;
  
  static
  {
    if (!ConfInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConfInfo()
  {
    setFilename(this.filename);
    setChecksum(this.checksum);
    setTimestamp(this.timestamp);
    setPfutimestamp(this.pfutimestamp);
    setGettype(this.gettype);
    setVersion(this.version);
  }
  
  public ConfInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setFilename(paramString1);
    setChecksum(paramString2);
    setTimestamp(paramInt1);
    setPfutimestamp(paramInt2);
    setGettype(paramInt3);
    setVersion(paramInt4);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ConfInfo";
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
      paramObject = (ConfInfo)paramObject;
    } while ((!JceUtil.equals(this.filename, paramObject.filename)) || (!JceUtil.equals(this.checksum, paramObject.checksum)) || (!JceUtil.equals(this.timestamp, paramObject.timestamp)) || (!JceUtil.equals(this.pfutimestamp, paramObject.pfutimestamp)) || (!JceUtil.equals(this.gettype, paramObject.gettype)) || (!JceUtil.equals(this.version, paramObject.version)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ConfInfo";
  }
  
  public String getChecksum()
  {
    return this.checksum;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public int getGettype()
  {
    return this.gettype;
  }
  
  public int getPfutimestamp()
  {
    return this.pfutimestamp;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
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
    setFilename(paramJceInputStream.readString(0, true));
    setChecksum(paramJceInputStream.readString(1, true));
    setTimestamp(paramJceInputStream.read(this.timestamp, 2, true));
    setPfutimestamp(paramJceInputStream.read(this.pfutimestamp, 3, false));
    setGettype(paramJceInputStream.read(this.gettype, 4, false));
    setVersion(paramJceInputStream.read(this.version, 5, false));
  }
  
  public void setChecksum(String paramString)
  {
    this.checksum = paramString;
  }
  
  public void setFilename(String paramString)
  {
    this.filename = paramString;
  }
  
  public void setGettype(int paramInt)
  {
    this.gettype = paramInt;
  }
  
  public void setPfutimestamp(int paramInt)
  {
    this.pfutimestamp = paramInt;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.timestamp = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.filename, 0);
    paramJceOutputStream.write(this.checksum, 1);
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.pfutimestamp, 3);
    paramJceOutputStream.write(this.gettype, 4);
    paramJceOutputStream.write(this.version, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ConfInfo
 * JD-Core Version:    0.7.0.1
 */