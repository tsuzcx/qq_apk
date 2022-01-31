package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VirusServerInfo
  extends JceStruct
  implements Cloneable
{
  public String advise = "";
  public boolean bUpdate = true;
  public int engine_version = 2;
  public String short_desc = "";
  public String strTips = "";
  public int timestamp = 0;
  public String url = "";
  public int version = 0;
  
  static
  {
    if (!VirusServerInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public VirusServerInfo()
  {
    setStrTips(this.strTips);
    setBUpdate(this.bUpdate);
    setVersion(this.version);
    setTimestamp(this.timestamp);
    setUrl(this.url);
    setShort_desc(this.short_desc);
    setAdvise(this.advise);
    setEngine_version(this.engine_version);
  }
  
  public VirusServerInfo(String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    setStrTips(paramString1);
    setBUpdate(paramBoolean);
    setVersion(paramInt1);
    setTimestamp(paramInt2);
    setUrl(paramString2);
    setShort_desc(paramString3);
    setAdvise(paramString4);
    setEngine_version(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.VirusServerInfo";
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
      paramObject = (VirusServerInfo)paramObject;
    } while ((!JceUtil.equals(this.strTips, paramObject.strTips)) || (!JceUtil.equals(this.bUpdate, paramObject.bUpdate)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.timestamp, paramObject.timestamp)) || (!JceUtil.equals(this.url, paramObject.url)) || (!JceUtil.equals(this.short_desc, paramObject.short_desc)) || (!JceUtil.equals(this.advise, paramObject.advise)) || (!JceUtil.equals(this.engine_version, paramObject.engine_version)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.VirusServerInfo";
  }
  
  public String getAdvise()
  {
    return this.advise;
  }
  
  public boolean getBUpdate()
  {
    return this.bUpdate;
  }
  
  public int getEngine_version()
  {
    return this.engine_version;
  }
  
  public String getShort_desc()
  {
    return this.short_desc;
  }
  
  public String getStrTips()
  {
    return this.strTips;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getUrl()
  {
    return this.url;
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
    setStrTips(paramJceInputStream.readString(0, true));
    setBUpdate(paramJceInputStream.read(this.bUpdate, 1, true));
    setVersion(paramJceInputStream.read(this.version, 2, true));
    setTimestamp(paramJceInputStream.read(this.timestamp, 3, true));
    setUrl(paramJceInputStream.readString(4, true));
    setShort_desc(paramJceInputStream.readString(5, true));
    setAdvise(paramJceInputStream.readString(6, true));
    setEngine_version(paramJceInputStream.read(this.engine_version, 7, false));
  }
  
  public void setAdvise(String paramString)
  {
    this.advise = paramString;
  }
  
  public void setBUpdate(boolean paramBoolean)
  {
    this.bUpdate = paramBoolean;
  }
  
  public void setEngine_version(int paramInt)
  {
    this.engine_version = paramInt;
  }
  
  public void setShort_desc(String paramString)
  {
    this.short_desc = paramString;
  }
  
  public void setStrTips(String paramString)
  {
    this.strTips = paramString;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.timestamp = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strTips, 0);
    paramJceOutputStream.write(this.bUpdate, 1);
    paramJceOutputStream.write(this.version, 2);
    paramJceOutputStream.write(this.timestamp, 3);
    paramJceOutputStream.write(this.url, 4);
    paramJceOutputStream.write(this.short_desc, 5);
    paramJceOutputStream.write(this.advise, 6);
    paramJceOutputStream.write(this.engine_version, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.VirusServerInfo
 * JD-Core Version:    0.7.0.1
 */