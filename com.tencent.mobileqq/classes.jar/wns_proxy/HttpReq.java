package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class HttpReq
  extends JceStruct
  implements Cloneable
{
  static int cache_method;
  public String body = "";
  public String domain = "";
  public String header = "";
  public int method;
  
  public HttpReq() {}
  
  public HttpReq(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.method = paramInt;
    this.header = paramString1;
    this.body = paramString2;
    this.domain = paramString3;
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
    paramStringBuilder.display(this.method, "method");
    paramStringBuilder.display(this.header, "header");
    paramStringBuilder.display(this.body, "body");
    paramStringBuilder.display(this.domain, "domain");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.method, true);
    paramStringBuilder.displaySimple(this.header, true);
    paramStringBuilder.displaySimple(this.body, true);
    paramStringBuilder.displaySimple(this.domain, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (HttpReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.method, paramObject.method))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.header, paramObject.header))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.body, paramObject.body))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.domain, paramObject.domain)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
    this.method = paramJceInputStream.read(this.method, 0, false);
    this.header = paramJceInputStream.readString(1, false);
    this.body = paramJceInputStream.readString(2, false);
    this.domain = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.method, 0);
    String str = this.header;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.body;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.domain;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wns_proxy.HttpReq
 * JD-Core Version:    0.7.0.1
 */