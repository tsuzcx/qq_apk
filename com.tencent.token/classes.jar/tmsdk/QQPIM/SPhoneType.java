package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SPhoneType
  extends JceStruct
  implements Cloneable
{
  public int phonetype = 0;
  
  static
  {
    if (!SPhoneType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SPhoneType()
  {
    setPhonetype(this.phonetype);
  }
  
  public SPhoneType(int paramInt)
  {
    setPhonetype(paramInt);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SPhoneType";
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
    paramObject = (SPhoneType)paramObject;
    return JceUtil.equals(this.phonetype, paramObject.phonetype);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SPhoneType";
  }
  
  public int getPhonetype()
  {
    return this.phonetype;
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
  }
  
  public void setPhonetype(int paramInt)
  {
    this.phonetype = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phonetype, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SPhoneType
 * JD-Core Version:    0.7.0.1
 */