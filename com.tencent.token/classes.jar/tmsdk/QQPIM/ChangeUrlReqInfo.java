package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ChangeUrlReqInfo
  extends JceStruct
  implements Cloneable
{
  public String url = "";
  
  static
  {
    if (!ChangeUrlReqInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChangeUrlReqInfo()
  {
    setUrl(this.url);
  }
  
  public ChangeUrlReqInfo(String paramString)
  {
    setUrl(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ChangeUrlReqInfo";
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
    paramObject = (ChangeUrlReqInfo)paramObject;
    return JceUtil.equals(this.url, paramObject.url);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ChangeUrlReqInfo";
  }
  
  public String getUrl()
  {
    return this.url;
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
    setUrl(paramJceInputStream.readString(0, true));
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ChangeUrlReqInfo
 * JD-Core Version:    0.7.0.1
 */