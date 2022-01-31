package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TipsReqInfo
  extends JceStruct
  implements Cloneable
{
  public String pkgname = "";
  
  static
  {
    if (!TipsReqInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TipsReqInfo()
  {
    setPkgname(this.pkgname);
  }
  
  public TipsReqInfo(String paramString)
  {
    setPkgname(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.TipsReqInfo";
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
    paramObject = (TipsReqInfo)paramObject;
    return JceUtil.equals(this.pkgname, paramObject.pkgname);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.TipsReqInfo";
  }
  
  public String getPkgname()
  {
    return this.pkgname;
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
    setPkgname(paramJceInputStream.readString(0, false));
  }
  
  public void setPkgname(String paramString)
  {
    this.pkgname = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.pkgname != null) {
      paramJceOutputStream.write(this.pkgname, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TipsReqInfo
 * JD-Core Version:    0.7.0.1
 */