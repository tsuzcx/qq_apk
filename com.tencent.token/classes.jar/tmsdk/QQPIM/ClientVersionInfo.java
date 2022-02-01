package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ClientVersionInfo
  extends JceStruct
  implements Cloneable
{
  public String checksum = "";
  public int id = 0;
  public String info = "";
  public int version = 0;
  
  public ClientVersionInfo()
  {
    setId(this.id);
    setVersion(this.version);
    setInfo(this.info);
    setChecksum(this.checksum);
  }
  
  public ClientVersionInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    setId(paramInt1);
    setVersion(paramInt2);
    setInfo(paramString1);
    setChecksum(paramString2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ClientVersionInfo";
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
    paramObject = (ClientVersionInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.version, paramObject.version))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.info, paramObject.info))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.checksum, paramObject.checksum)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ClientVersionInfo";
  }
  
  public String getChecksum()
  {
    return this.checksum;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getInfo()
  {
    return this.info;
  }
  
  public int getVersion()
  {
    return this.version;
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
    setId(paramJceInputStream.read(this.id, 0, true));
    setVersion(paramJceInputStream.read(this.version, 1, true));
    setInfo(paramJceInputStream.readString(2, false));
    setChecksum(paramJceInputStream.readString(3, false));
  }
  
  public void setChecksum(String paramString)
  {
    this.checksum = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setInfo(String paramString)
  {
    this.info = paramString;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.version, 1);
    String str = this.info;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.checksum;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ClientVersionInfo
 * JD-Core Version:    0.7.0.1
 */