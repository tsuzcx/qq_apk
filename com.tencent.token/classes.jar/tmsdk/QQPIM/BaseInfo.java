package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class BaseInfo
  extends JceStruct
  implements Cloneable
{
  public String tipsid = "";
  
  public BaseInfo()
  {
    setTipsid(this.tipsid);
  }
  
  public BaseInfo(String paramString)
  {
    setTipsid(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.BaseInfo";
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
    paramObject = (BaseInfo)paramObject;
    return JceUtil.equals(this.tipsid, paramObject.tipsid);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.BaseInfo";
  }
  
  public String getTipsid()
  {
    return this.tipsid;
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
    setTipsid(paramJceInputStream.readString(0, true));
  }
  
  public void setTipsid(String paramString)
  {
    this.tipsid = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tipsid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.BaseInfo
 * JD-Core Version:    0.7.0.1
 */