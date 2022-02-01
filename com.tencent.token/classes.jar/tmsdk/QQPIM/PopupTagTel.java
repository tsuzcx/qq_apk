package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PopupTagTel
  extends JceStruct
  implements Cloneable
{
  public String cls = "";
  public int daylimit = 0;
  public int ispopup = 0;
  
  public PopupTagTel() {}
  
  public PopupTagTel(int paramInt1, String paramString, int paramInt2)
  {
    this.ispopup = paramInt1;
    this.cls = paramString;
    this.daylimit = paramInt2;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.PopupTagTel";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.ispopup, "ispopup");
    paramStringBuilder.display(this.cls, "cls");
    paramStringBuilder.display(this.daylimit, "daylimit");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (PopupTagTel)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.ispopup, paramObject.ispopup))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.cls, paramObject.cls))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.daylimit, paramObject.daylimit)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.PopupTagTel";
  }
  
  public String getCls()
  {
    return this.cls;
  }
  
  public int getDaylimit()
  {
    return this.daylimit;
  }
  
  public int getIspopup()
  {
    return this.ispopup;
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
    this.ispopup = paramJceInputStream.read(this.ispopup, 0, true);
    this.cls = paramJceInputStream.readString(1, false);
    this.daylimit = paramJceInputStream.read(this.daylimit, 2, false);
  }
  
  public void setCls(String paramString)
  {
    this.cls = paramString;
  }
  
  public void setDaylimit(int paramInt)
  {
    this.daylimit = paramInt;
  }
  
  public void setIspopup(int paramInt)
  {
    this.ispopup = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ispopup, 0);
    String str = this.cls;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.daylimit, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.PopupTagTel
 * JD-Core Version:    0.7.0.1
 */