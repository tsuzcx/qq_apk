package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UrlCheckResponse
  extends JceStruct
  implements Cloneable
{
  static int fh;
  static int fi;
  public int UrlType = 0;
  public String body = "";
  public String desc = "";
  public int evilclass = 0;
  public int mainHarmId = UrlCheckType.CHECK_REGULAR.value();
  public int seq = 0;
  public int subHarmId = UrlCheckType.CHECK_REGULAR.value();
  public String title = "";
  public String url = "";
  
  static
  {
    if (!UrlCheckResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      fh = 0;
      fi = 0;
      return;
    }
  }
  
  public UrlCheckResponse() {}
  
  public UrlCheckResponse(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, String paramString4, int paramInt5)
  {
    this.url = paramString1;
    this.mainHarmId = paramInt1;
    this.subHarmId = paramInt2;
    this.seq = paramInt3;
    this.desc = paramString2;
    this.UrlType = paramInt4;
    this.title = paramString3;
    this.body = paramString4;
    this.evilclass = paramInt5;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.UrlCheckResponse";
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
    paramStringBuilder.display(this.mainHarmId, "mainHarmId");
    paramStringBuilder.display(this.subHarmId, "subHarmId");
    paramStringBuilder.display(this.seq, "seq");
    paramStringBuilder.display(this.desc, "desc");
    paramStringBuilder.display(this.UrlType, "UrlType");
    paramStringBuilder.display(this.title, "title");
    paramStringBuilder.display(this.body, "body");
    paramStringBuilder.display(this.evilclass, "evilclass");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UrlCheckResponse)paramObject;
    } while ((!JceUtil.equals(this.url, paramObject.url)) || (!JceUtil.equals(this.mainHarmId, paramObject.mainHarmId)) || (!JceUtil.equals(this.subHarmId, paramObject.subHarmId)) || (!JceUtil.equals(this.seq, paramObject.seq)) || (!JceUtil.equals(this.desc, paramObject.desc)) || (!JceUtil.equals(this.UrlType, paramObject.UrlType)) || (!JceUtil.equals(this.title, paramObject.title)) || (!JceUtil.equals(this.body, paramObject.body)) || (!JceUtil.equals(this.evilclass, paramObject.evilclass)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.UrlCheckResponse";
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getEvilclass()
  {
    return this.evilclass;
  }
  
  public int getMainHarmId()
  {
    return this.mainHarmId;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public int getSubHarmId()
  {
    return this.subHarmId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getUrlType()
  {
    return this.UrlType;
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
    this.mainHarmId = paramJceInputStream.read(this.mainHarmId, 1, true);
    this.subHarmId = paramJceInputStream.read(this.subHarmId, 2, false);
    this.seq = paramJceInputStream.read(this.seq, 3, false);
    this.desc = paramJceInputStream.readString(4, false);
    this.UrlType = paramJceInputStream.read(this.UrlType, 5, false);
    this.title = paramJceInputStream.readString(6, false);
    this.body = paramJceInputStream.readString(7, false);
    this.evilclass = paramJceInputStream.read(this.evilclass, 8, false);
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setEvilclass(int paramInt)
  {
    this.evilclass = paramInt;
  }
  
  public void setMainHarmId(int paramInt)
  {
    this.mainHarmId = paramInt;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
  
  public void setSubHarmId(int paramInt)
  {
    this.subHarmId = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUrlType(int paramInt)
  {
    this.UrlType = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url, 0);
    paramJceOutputStream.write(this.mainHarmId, 1);
    paramJceOutputStream.write(this.subHarmId, 2);
    paramJceOutputStream.write(this.seq, 3);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 4);
    }
    paramJceOutputStream.write(this.UrlType, 5);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 6);
    }
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 7);
    }
    paramJceOutputStream.write(this.evilclass, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UrlCheckResponse
 * JD-Core Version:    0.7.0.1
 */