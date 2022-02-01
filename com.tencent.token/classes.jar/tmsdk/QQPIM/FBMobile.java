package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class FBMobile
  extends JceStruct
  implements Cloneable
{
  public String city = "";
  public int mtype = 0;
  public String phone = "";
  public int sp = 0;
  public String state = "";
  
  public FBMobile()
  {
    setPhone(this.phone);
    setMtype(this.mtype);
    setState(this.state);
    setCity(this.city);
    setSp(this.sp);
  }
  
  public FBMobile(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    setPhone(paramString1);
    setMtype(paramInt1);
    setState(paramString2);
    setCity(paramString3);
    setSp(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.FBMobile";
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
    paramObject = (FBMobile)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.phone, paramObject.phone))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.mtype, paramObject.mtype))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.state, paramObject.state))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.city, paramObject.city))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.sp, paramObject.sp)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.FBMobile";
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public int getMtype()
  {
    return this.mtype;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public int getSp()
  {
    return this.sp;
  }
  
  public String getState()
  {
    return this.state;
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
    setPhone(paramJceInputStream.readString(0, true));
    setMtype(paramJceInputStream.read(this.mtype, 1, true));
    setState(paramJceInputStream.readString(2, true));
    setCity(paramJceInputStream.readString(3, true));
    setSp(paramJceInputStream.read(this.sp, 4, true));
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setMtype(int paramInt)
  {
    this.mtype = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setSp(int paramInt)
  {
    this.sp = paramInt;
  }
  
  public void setState(String paramString)
  {
    this.state = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phone, 0);
    paramJceOutputStream.write(this.mtype, 1);
    paramJceOutputStream.write(this.state, 2);
    paramJceOutputStream.write(this.city, 3);
    paramJceOutputStream.write(this.sp, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FBMobile
 * JD-Core Version:    0.7.0.1
 */