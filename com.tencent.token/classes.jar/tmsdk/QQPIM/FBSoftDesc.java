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
    paramObject = (FBSoftDesc)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.softkey, paramObject.softkey))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.desc, paramObject.desc)) {
        bool1 = true;
      }
    }
    return bool1;
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