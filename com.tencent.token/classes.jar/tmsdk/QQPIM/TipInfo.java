package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TipInfo
  extends JceStruct
  implements Cloneable
{
  public String strTips = "";
  public String strTitle = "";
  
  static
  {
    if (!TipInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TipInfo()
  {
    setStrTips(this.strTips);
    setStrTitle(this.strTitle);
  }
  
  public TipInfo(String paramString1, String paramString2)
  {
    setStrTips(paramString1);
    setStrTitle(paramString2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.TipInfo";
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
      paramObject = (TipInfo)paramObject;
    } while ((!JceUtil.equals(this.strTips, paramObject.strTips)) || (!JceUtil.equals(this.strTitle, paramObject.strTitle)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.TipInfo";
  }
  
  public String getStrTips()
  {
    return this.strTips;
  }
  
  public String getStrTitle()
  {
    return this.strTitle;
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
    setStrTips(paramJceInputStream.readString(0, true));
    setStrTitle(paramJceInputStream.readString(1, false));
  }
  
  public void setStrTips(String paramString)
  {
    this.strTips = paramString;
  }
  
  public void setStrTitle(String paramString)
  {
    this.strTitle = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strTips, 0);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TipInfo
 * JD-Core Version:    0.7.0.1
 */