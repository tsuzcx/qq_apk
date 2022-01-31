package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class FBSoftDesc
  extends JceStruct
  implements Cloneable
{
  static SoftKey dw;
  public String desc = "";
  public SoftKey softkey = null;
  
  static
  {
    if (!FBSoftDesc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FBSoftDesc()
  {
    setSoftkey(this.softkey);
    setDesc(this.desc);
  }
  
  public FBSoftDesc(SoftKey paramSoftKey, String paramString)
  {
    setSoftkey(paramSoftKey);
    setDesc(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.FBSoftDesc";
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
      paramObject = (FBSoftDesc)paramObject;
    } while ((!JceUtil.equals(this.softkey, paramObject.softkey)) || (!JceUtil.equals(this.desc, paramObject.desc)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.FBSoftDesc";
  }
  
  public String getDesc()
  {
    return this.desc;
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
    setDesc(paramJceInputStream.readString(1, true));
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setSoftkey(SoftKey paramSoftKey)
  {
    this.softkey = paramSoftKey;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    paramJceOutputStream.write(this.desc, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FBSoftDesc
 * JD-Core Version:    0.7.0.1
 */