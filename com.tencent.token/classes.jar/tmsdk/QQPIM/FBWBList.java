package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class FBWBList
  extends JceStruct
  implements Cloneable
{
  public int listtype = 0;
  public String phone = "";
  
  public FBWBList()
  {
    setListtype(this.listtype);
    setPhone(this.phone);
  }
  
  public FBWBList(int paramInt, String paramString)
  {
    setListtype(paramInt);
    setPhone(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.FBWBList";
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
    paramObject = (FBWBList)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.listtype, paramObject.listtype))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.phone, paramObject.phone)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.FBWBList";
  }
  
  public int getListtype()
  {
    return this.listtype;
  }
  
  public String getPhone()
  {
    return this.phone;
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
    setListtype(paramJceInputStream.read(this.listtype, 0, true));
    setPhone(paramJceInputStream.readString(1, true));
  }
  
  public void setListtype(int paramInt)
  {
    this.listtype = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.listtype, 0);
    paramJceOutputStream.write(this.phone, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FBWBList
 * JD-Core Version:    0.7.0.1
 */