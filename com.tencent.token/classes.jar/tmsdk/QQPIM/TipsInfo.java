package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TipsInfo
  extends JceStruct
  implements Cloneable
{
  public int atype = 0;
  public int bgcolor = 0;
  public int icontype = 0;
  public String msg = "";
  public String title = "";
  public int type = 0;
  
  static
  {
    if (!TipsInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TipsInfo() {}
  
  public TipsInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.title = paramString1;
    this.msg = paramString2;
    this.type = paramInt1;
    this.atype = paramInt2;
    this.icontype = paramInt3;
    this.bgcolor = paramInt4;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.TipsInfo";
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
      paramObject = (TipsInfo)paramObject;
    } while ((!JceUtil.equals(this.title, paramObject.title)) || (!JceUtil.equals(this.msg, paramObject.msg)) || (!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.atype, paramObject.atype)) || (!JceUtil.equals(this.icontype, paramObject.icontype)) || (!JceUtil.equals(this.bgcolor, paramObject.bgcolor)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.TipsInfo";
  }
  
  public int getAtype()
  {
    return this.atype;
  }
  
  public int getBgcolor()
  {
    return this.bgcolor;
  }
  
  public int getIcontype()
  {
    return this.icontype;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getType()
  {
    return this.type;
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
    this.title = paramJceInputStream.readString(0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
    this.atype = paramJceInputStream.read(this.atype, 3, true);
    this.icontype = paramJceInputStream.read(this.icontype, 4, false);
    this.bgcolor = paramJceInputStream.read(this.bgcolor, 5, false);
  }
  
  public void setAtype(int paramInt)
  {
    this.atype = paramInt;
  }
  
  public void setBgcolor(int paramInt)
  {
    this.bgcolor = paramInt;
  }
  
  public void setIcontype(int paramInt)
  {
    this.icontype = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.title, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.atype, 3);
    paramJceOutputStream.write(this.icontype, 4);
    paramJceOutputStream.write(this.bgcolor, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TipsInfo
 * JD-Core Version:    0.7.0.1
 */