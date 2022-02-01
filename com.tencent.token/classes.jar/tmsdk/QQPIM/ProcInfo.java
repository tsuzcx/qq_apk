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
    paramObject = (ProcInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.file, paramObject.file))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.desc, paramObject.desc))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.uid, paramObject.uid)) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    String str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ProcInfo
 * JD-Core Version:    0.7.0.1
 */