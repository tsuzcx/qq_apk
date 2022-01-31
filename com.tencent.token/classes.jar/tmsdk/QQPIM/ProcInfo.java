package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ProcInfo
  extends JceStruct
  implements Cloneable
{
  public String desc = "";
  public String file = "";
  public String uid = "";
  
  static
  {
    if (!ProcInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProcInfo()
  {
    setFile(this.file);
    setDesc(this.desc);
    setUid(this.uid);
  }
  
  public ProcInfo(String paramString1, String paramString2, String paramString3)
  {
    setFile(paramString1);
    setDesc(paramString2);
    setUid(paramString3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ProcInfo";
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
      paramObject = (ProcInfo)paramObject;
    } while ((!JceUtil.equals(this.file, paramObject.file)) || (!JceUtil.equals(this.desc, paramObject.desc)) || (!JceUtil.equals(this.uid, paramObject.uid)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ProcInfo";
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getFile()
  {
    return this.file;
  }
  
  public String getUid()
  {
    return this.uid;
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
    setFile(paramJceInputStream.readString(0, true));
    setDesc(paramJceInputStream.readString(1, false));
    setUid(paramJceInputStream.readString(2, false));
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setFile(String paramString)
  {
    this.file = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.file, 0);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ProcInfo
 * JD-Core Version:    0.7.0.1
 */