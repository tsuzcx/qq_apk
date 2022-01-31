package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class s_app_info
  extends JceStruct
  implements Cloneable
{
  public int appid = 0;
  public String appname = "";
  public int apptype = 0;
  public String downloadurl = "";
  public String downloadurl_android = "";
  public String h5_url = "";
  public String iconurl = "";
  public int isrecommend = 0;
  public String packagename = "";
  public String recommendcomment = "";
  public String summary = "";
  
  static
  {
    if (!s_app_info.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public s_app_info() {}
  
  public s_app_info(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8, int paramInt3)
  {
    this.appid = paramInt1;
    this.appname = paramString1;
    this.iconurl = paramString2;
    this.downloadurl = paramString3;
    this.downloadurl_android = paramString4;
    this.summary = paramString5;
    this.isrecommend = paramInt2;
    this.packagename = paramString6;
    this.h5_url = paramString7;
    this.recommendcomment = paramString8;
    this.apptype = paramInt3;
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
    paramStringBuilder.display(this.appid, "appid");
    paramStringBuilder.display(this.appname, "appname");
    paramStringBuilder.display(this.iconurl, "iconurl");
    paramStringBuilder.display(this.downloadurl, "downloadurl");
    paramStringBuilder.display(this.downloadurl_android, "downloadurl_android");
    paramStringBuilder.display(this.summary, "summary");
    paramStringBuilder.display(this.isrecommend, "isrecommend");
    paramStringBuilder.display(this.packagename, "packagename");
    paramStringBuilder.display(this.h5_url, "h5_url");
    paramStringBuilder.display(this.recommendcomment, "recommendcomment");
    paramStringBuilder.display(this.apptype, "apptype");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.appid, true);
    paramStringBuilder.displaySimple(this.appname, true);
    paramStringBuilder.displaySimple(this.iconurl, true);
    paramStringBuilder.displaySimple(this.downloadurl, true);
    paramStringBuilder.displaySimple(this.downloadurl_android, true);
    paramStringBuilder.displaySimple(this.summary, true);
    paramStringBuilder.displaySimple(this.isrecommend, true);
    paramStringBuilder.displaySimple(this.packagename, true);
    paramStringBuilder.displaySimple(this.h5_url, true);
    paramStringBuilder.displaySimple(this.recommendcomment, true);
    paramStringBuilder.displaySimple(this.apptype, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (s_app_info)paramObject;
    } while ((!JceUtil.equals(this.appid, paramObject.appid)) || (!JceUtil.equals(this.appname, paramObject.appname)) || (!JceUtil.equals(this.iconurl, paramObject.iconurl)) || (!JceUtil.equals(this.downloadurl, paramObject.downloadurl)) || (!JceUtil.equals(this.downloadurl_android, paramObject.downloadurl_android)) || (!JceUtil.equals(this.summary, paramObject.summary)) || (!JceUtil.equals(this.isrecommend, paramObject.isrecommend)) || (!JceUtil.equals(this.packagename, paramObject.packagename)) || (!JceUtil.equals(this.h5_url, paramObject.h5_url)) || (!JceUtil.equals(this.recommendcomment, paramObject.recommendcomment)) || (!JceUtil.equals(this.apptype, paramObject.apptype)));
    return true;
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
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.appname = paramJceInputStream.readString(1, false);
    this.iconurl = paramJceInputStream.readString(2, false);
    this.downloadurl = paramJceInputStream.readString(3, false);
    this.downloadurl_android = paramJceInputStream.readString(4, false);
    this.summary = paramJceInputStream.readString(5, false);
    this.isrecommend = paramJceInputStream.read(this.isrecommend, 6, false);
    this.packagename = paramJceInputStream.readString(7, false);
    this.h5_url = paramJceInputStream.readString(8, false);
    this.recommendcomment = paramJceInputStream.readString(9, false);
    this.apptype = paramJceInputStream.read(this.apptype, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    if (this.appname != null) {
      paramJceOutputStream.write(this.appname, 1);
    }
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 2);
    }
    if (this.downloadurl != null) {
      paramJceOutputStream.write(this.downloadurl, 3);
    }
    if (this.downloadurl_android != null) {
      paramJceOutputStream.write(this.downloadurl_android, 4);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 5);
    }
    paramJceOutputStream.write(this.isrecommend, 6);
    if (this.packagename != null) {
      paramJceOutputStream.write(this.packagename, 7);
    }
    if (this.h5_url != null) {
      paramJceOutputStream.write(this.h5_url, 8);
    }
    if (this.recommendcomment != null) {
      paramJceOutputStream.write(this.recommendcomment, 9);
    }
    paramJceOutputStream.write(this.apptype, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_app_info
 * JD-Core Version:    0.7.0.1
 */