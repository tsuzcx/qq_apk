package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ChangeUrlResInfo
  extends JceStruct
  implements Cloneable
{
  public String changeurl = "";
  
  static
  {
    if (!ChangeUrlResInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChangeUrlResInfo()
  {
    setChangeurl(this.changeurl);
  }
  
  public ChangeUrlResInfo(String paramString)
  {
    setChangeurl(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ChangeUrlResInfo";
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
    paramObject = (ChangeUrlResInfo)paramObject;
    return JceUtil.equals(this.changeurl, paramObject.changeurl);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ChangeUrlResInfo";
  }
  
  public String getChangeurl()
  {
    return this.changeurl;
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
    setChangeurl(paramJceInputStream.readString(0, true));
  }
  
  public void setChangeurl(String paramString)
  {
    this.changeurl = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.changeurl, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ChangeUrlResInfo
 * JD-Core Version:    0.7.0.1
 */