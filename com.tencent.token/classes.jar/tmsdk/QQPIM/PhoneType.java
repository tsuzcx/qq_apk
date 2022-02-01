package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PhoneType
  extends JceStruct
  implements Cloneable
{
  public int phonetype = 0;
  public int subplatform = ESubPlatform.ESP_NONE.value();
  
  public PhoneType()
  {
    setPhonetype(this.phonetype);
    setSubplatform(this.subplatform);
  }
  
  public PhoneType(int paramInt1, int paramInt2)
  {
    setPhonetype(paramInt1);
    setSubplatform(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.PhoneType";
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
    paramObject = (PhoneType)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.phonetype, paramObject.phonetype))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.subplatform, paramObject.subplatform)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.PhoneType";
  }
  
  public int getPhonetype()
  {
    return this.phonetype;
  }
  
  public int getSubplatform()
  {
    return this.subplatform;
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
    setPhonetype(paramJceInputStream.read(this.phonetype, 0, true));
    setSubplatform(paramJceInputStream.read(this.subplatform, 1, false));
  }
  
  public void setPhonetype(int paramInt)
  {
    this.phonetype = paramInt;
  }
  
  public void setSubplatform(int paramInt)
  {
    this.subplatform = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phonetype, 0);
    paramJceOutputStream.write(this.subplatform, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.PhoneType
 * JD-Core Version:    0.7.0.1
 */