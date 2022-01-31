package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class MalSoftType
  extends JceStruct
  implements Cloneable
{
  static SoftKey dw;
  public int malsofttype = 0;
  public SoftKey softkey = null;
  
  static
  {
    if (!MalSoftType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MalSoftType()
  {
    setSoftkey(this.softkey);
    setMalsofttype(this.malsofttype);
  }
  
  public MalSoftType(SoftKey paramSoftKey, int paramInt)
  {
    setSoftkey(paramSoftKey);
    setMalsofttype(paramInt);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.MalSoftType";
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
      paramObject = (MalSoftType)paramObject;
    } while ((!JceUtil.equals(this.softkey, paramObject.softkey)) || (!JceUtil.equals(this.malsofttype, paramObject.malsofttype)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.MalSoftType";
  }
  
  public int getMalsofttype()
  {
    return this.malsofttype;
  }
  
  public SoftKey getSoftkey()
  {
    return this.softkey;
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
    if (dw == null) {
      dw = new SoftKey();
    }
    setSoftkey((SoftKey)paramJceInputStream.read(dw, 0, true));
    setMalsofttype(paramJceInputStream.read(this.malsofttype, 1, true));
  }
  
  public void setMalsofttype(int paramInt)
  {
    this.malsofttype = paramInt;
  }
  
  public void setSoftkey(SoftKey paramSoftKey)
  {
    this.softkey = paramSoftKey;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    paramJceOutputStream.write(this.malsofttype, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.MalSoftType
 * JD-Core Version:    0.7.0.1
 */