package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class HotwordInfo
  extends JceStruct
  implements Cloneable
{
  public String hotword = "";
  
  static
  {
    if (!HotwordInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HotwordInfo()
  {
    setHotword(this.hotword);
  }
  
  public HotwordInfo(String paramString)
  {
    setHotword(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.HotwordInfo";
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
    paramObject = (HotwordInfo)paramObject;
    return JceUtil.equals(this.hotword, paramObject.hotword);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.HotwordInfo";
  }
  
  public String getHotword()
  {
    return this.hotword;
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
    setHotword(paramJceInputStream.readString(0, true));
  }
  
  public void setHotword(String paramString)
  {
    this.hotword = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hotword, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.HotwordInfo
 * JD-Core Version:    0.7.0.1
 */