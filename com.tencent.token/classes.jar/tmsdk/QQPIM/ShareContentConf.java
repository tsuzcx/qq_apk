package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ShareContentConf
  extends JceStruct
  implements Cloneable
{
  public int cls = 0;
  public String content = "";
  public String title = "";
  public String url = "";
  
  public ShareContentConf() {}
  
  public ShareContentConf(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.cls = paramInt;
    this.title = paramString1;
    this.content = paramString2;
    this.url = paramString3;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ShareContentConf";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.cls, "cls");
    paramStringBuilder.display(this.title, "title");
    paramStringBuilder.display(this.content, "content");
    paramStringBuilder.display(this.url, "url");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ShareContentConf)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.cls, paramObject.cls))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.title, paramObject.title))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.content, paramObject.content))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.url, paramObject.url)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ShareContentConf";
  }
  
  public int getCls()
  {
    return this.cls;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUrl()
  {
    return this.url;
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
    this.cls = paramJceInputStream.read(this.cls, 0, true);
    this.title = paramJceInputStream.readString(1, true);
    this.content = paramJceInputStream.readString(2, true);
    this.url = paramJceInputStream.readString(3, false);
  }
  
  public void setCls(int paramInt)
  {
    this.cls = paramInt;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cls, 0);
    paramJceOutputStream.write(this.title, 1);
    paramJceOutputStream.write(this.content, 2);
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ShareContentConf
 * JD-Core Version:    0.7.0.1
 */