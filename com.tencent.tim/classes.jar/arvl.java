public class arvl
{
  public String appId;
  public String appName;
  public boolean ddf = true;
  public boolean ddg = true;
  public boolean ddh;
  public boolean ddi;
  public boolean ddj;
  public int downloadType = 0;
  public boolean isAutoInstall;
  public String packageName;
  public int updateType = 0;
  public String urlStr;
  public int versionCode;
  
  public arvl(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.packageName = paramString2;
  }
  
  public arvl(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.appId = paramString1;
    this.packageName = paramString2;
    this.appName = paramString3;
    this.urlStr = paramString4;
    this.ddi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvl
 * JD-Core Version:    0.7.0.1
 */