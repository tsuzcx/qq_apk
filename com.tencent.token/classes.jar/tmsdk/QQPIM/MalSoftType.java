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
    paramObject = (MalSoftType)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.softkey, paramObject.softkey))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.malsofttype, paramObject.malsofttype)) {
        bool1 = true;
      }
    }
    return bool1;
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