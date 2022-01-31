package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class FeatureKey
  extends JceStruct
  implements Cloneable
{
  public String cert = "";
  public int fileSize = 0;
  public String softName = "";
  public String uniCode = "";
  public String version = "";
  public int versionCode = 0;
  
  static
  {
    if (!FeatureKey.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FeatureKey()
  {
    setUniCode(this.uniCode);
    setSoftName(this.softName);
    setVersion(this.version);
    setVersionCode(this.versionCode);
    setCert(this.cert);
    setFileSize(this.fileSize);
  }
  
  public FeatureKey(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    setUniCode(paramString1);
    setSoftName(paramString2);
    setVersion(paramString3);
    setVersionCode(paramInt1);
    setCert(paramString4);
    setFileSize(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.FeatureKey";
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
      paramObject = (FeatureKey)paramObject;
    } while ((!JceUtil.equals(this.uniCode, paramObject.uniCode)) || (!JceUtil.equals(this.softName, paramObject.softName)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.versionCode, paramObject.versionCode)) || (!JceUtil.equals(this.cert, paramObject.cert)) || (!JceUtil.equals(this.fileSize, paramObject.fileSize)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.FeatureKey";
  }
  
  public String getCert()
  {
    return this.cert;
  }
  
  public int getFileSize()
  {
    return this.fileSize;
  }
  
  public String getSoftName()
  {
    return this.softName;
  }
  
  public String getUniCode()
  {
    return this.uniCode;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
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
    setUniCode(paramJceInputStream.readString(0, true));
    setSoftName(paramJceInputStream.readString(1, true));
    setVersion(paramJceInputStream.readString(2, true));
    setVersionCode(paramJceInputStream.read(this.versionCode, 3, false));
    setCert(paramJceInputStream.readString(4, false));
    setFileSize(paramJceInputStream.read(this.fileSize, 5, false));
  }
  
  public void setCert(String paramString)
  {
    this.cert = paramString;
  }
  
  public void setFileSize(int paramInt)
  {
    this.fileSize = paramInt;
  }
  
  public void setSoftName(String paramString)
  {
    this.softName = paramString;
  }
  
  public void setUniCode(String paramString)
  {
    this.uniCode = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uniCode, 0);
    paramJceOutputStream.write(this.softName, 1);
    paramJceOutputStream.write(this.version, 2);
    paramJceOutputStream.write(this.versionCode, 3);
    if (this.cert != null) {
      paramJceOutputStream.write(this.cert, 4);
    }
    paramJceOutputStream.write(this.fileSize, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FeatureKey
 * JD-Core Version:    0.7.0.1
 */