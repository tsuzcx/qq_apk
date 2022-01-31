package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UrlCheckRequest
  extends JceStruct
  implements Cloneable
{
  public int appId = 28;
  public String ext = "";
  public String guid = "";
  public int seq = 0;
  public String url = "";
  public int version = 0;
  
  static
  {
    if (!UrlCheckRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UrlCheckRequest() {}
  
  public UrlCheckRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    this.url = paramString1;
    this.ext = paramString2;
    this.seq = paramInt1;
    this.version = paramInt2;
    this.guid = paramString3;
    this.appId = paramInt3;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.UrlCheckRequest";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.url, "url");
    paramStringBuilder.display(this.ext, "ext");
    paramStringBuilder.display(this.seq, "seq");
    paramStringBuilder.display(this.version, "version");
    paramStringBuilder.display(this.guid, "guid");
    paramStringBuilder.display(this.appId, "appId");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UrlCheckRequest)paramObject;
    } while ((!JceUtil.equals(this.url, paramObject.url)) || (!JceUtil.equals(this.ext, paramObject.ext)) || (!JceUtil.equals(this.seq, paramObject.seq)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.guid, paramObject.guid)) || (!JceUtil.equals(this.appId, paramObject.appId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.UrlCheckRequest";
  }
  
  public int getAppId()
  {
    return this.appId;
  }
  
  public String getExt()
  {
    return this.ext;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public int getSeq()
  {
    return this.seq;
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
    this.url = paramJceInputStream.readString(0, true);
    this.ext = paramJceInputStream.readString(1, false);
    this.seq = paramJceInputStream.read(this.seq, 2, false);
    this.version = paramJceInputStream.read(this.version, 3, false);
    this.guid = paramJceInputStream.readString(4, false);
    this.appId = paramJceInputStream.read(this.appId, 5, false);
  }
  
  public void setAppId(int paramInt)
  {
    this.appId = paramInt;
  }
  
  public void setExt(String paramString)
  {
    this.ext = paramString;
  }
  
  public void setGuid(String paramString)
  {
    this.guid = paramString;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
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
    paramJceOutputStream.write(this.url, 0);
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 1);
    }
    paramJceOutputStream.write(this.seq, 2);
    paramJceOutputStream.write(this.version, 3);
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 4);
    }
    paramJceOutputStream.write(this.appId, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UrlCheckRequest
 * JD-Core Version:    0.7.0.1
 */