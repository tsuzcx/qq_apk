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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (TipInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.strTips, paramObject.strTips))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strTitle, paramObject.strTitle)) {
        bool1 = true;
      }
    }
    return bool1;
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
    String str = this.strTitle;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TipInfo
 * JD-Core Version:    0.7.0.1
 */