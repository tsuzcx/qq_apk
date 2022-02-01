package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PopupWarnSms
  extends JceStruct
  implements Cloneable
{
  public int daylimit = 0;
  public int ispopup = 0;
  
  public PopupWarnSms() {}
  
  public PopupWarnSms(int paramInt1, int paramInt2)
  {
    this.ispopup = paramInt1;
    this.daylimit = paramInt2;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.PopupWarnSms";
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
    paramStringBuilder.display(this.daylimit, "daylimit");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (PopupWarnSms)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.ispopup, paramObject.ispopup))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.daylimit, paramObject.daylimit)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.PopupWarnSms";
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
    this.daylimit = paramJceInputStream.read(this.daylimit, 1, false);
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
    paramJceOutputStream.write(this.daylimit, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.PopupWarnSms
 * JD-Core Version:    0.7.0.1
 */