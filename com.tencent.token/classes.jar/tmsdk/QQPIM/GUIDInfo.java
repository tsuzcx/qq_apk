package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class GUIDInfo
  extends JceStruct
  implements Cloneable
{
  public String guid = "";
  
  public GUIDInfo()
  {
    setGuid(this.guid);
  }
  
  public GUIDInfo(String paramString)
  {
    setGuid(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.GUIDInfo";
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
    if (paramObject == null) {
      return false;
    }
    paramObject = (GUIDInfo)paramObject;
    return JceUtil.equals(this.guid, paramObject.guid);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.GUIDInfo";
  }
  
  public String getGuid()
  {
    return this.guid;
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
    setGuid(paramJceInputStream.readString(0, true));
  }
  
  public void setGuid(String paramString)
  {
    this.guid = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.guid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.GUIDInfo
 * JD-Core Version:    0.7.0.1
 */