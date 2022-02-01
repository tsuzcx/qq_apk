import android.text.TextUtils;

public class arwn
{
  protected String appId;
  protected String appName;
  protected String cCL;
  protected String cCM;
  protected String channelId;
  protected String extraData;
  protected String kx;
  protected String packageName;
  protected String pageId;
  protected String posId;
  protected String recommendId;
  protected String url;
  protected int versionCode;
  protected String via;
  
  public static arwn a()
  {
    return new arwn();
  }
  
  private static String filterSplitStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("|", "");
  }
  
  public String Du()
  {
    return "";
  }
  
  public final String Dv()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(filterSplitStr(this.pageId));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.kx));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.posId));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.via));
    localStringBuilder.append("|");
    localStringBuilder.append(aroi.a().getUin());
    localStringBuilder.append("|");
    localStringBuilder.append(aroi.a().getAppVersionName());
    localStringBuilder.append("|");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.extraData));
    return localStringBuilder.toString();
  }
  
  public final String Dw()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(filterSplitStr(this.appName));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.packageName));
    localStringBuilder.append("|");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.appId));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.cCL));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.cCM));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.channelId));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.url));
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.recommendId));
    return localStringBuilder.toString();
  }
  
  public final String Dx()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  public final arwn a(int paramInt)
  {
    this.versionCode = paramInt;
    return this;
  }
  
  public final arwn a(String paramString)
  {
    this.appName = paramString;
    return this;
  }
  
  public final arwn b(String paramString)
  {
    this.packageName = paramString;
    return this;
  }
  
  public final arwn c(String paramString)
  {
    this.appId = paramString;
    return this;
  }
  
  public final arwn d(String paramString)
  {
    this.cCL = paramString;
    return this;
  }
  
  public final arwn e(String paramString)
  {
    this.cCM = paramString;
    return this;
  }
  
  public final arwn f(String paramString)
  {
    this.channelId = paramString;
    return this;
  }
  
  public final arwn g(String paramString)
  {
    this.url = paramString;
    return this;
  }
  
  public final arwn h(String paramString)
  {
    this.recommendId = paramString;
    return this;
  }
  
  public final arwn i(String paramString)
  {
    this.extraData = paramString;
    return this;
  }
  
  public final arwn j(String paramString)
  {
    this.kx = paramString;
    return this;
  }
  
  public final arwn k(String paramString)
  {
    this.pageId = paramString;
    return this;
  }
  
  public final arwn l(String paramString)
  {
    this.posId = paramString;
    return this;
  }
  
  public final arwn m(String paramString)
  {
    this.via = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwn
 * JD-Core Version:    0.7.0.1
 */