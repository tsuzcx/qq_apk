public class asap
{
  public String cDH = "0";
  public String iconUrl;
  public String kx = "0";
  public long length;
  public String name;
  public String packageName;
  public String pageId = "6000";
  public int progress;
  public int state = 1;
  public String url;
  public String via = "default_via";
  
  public static asap a(asap paramasap)
  {
    asap localasap = new asap();
    if (paramasap == null) {
      return localasap;
    }
    localasap.url = paramasap.url;
    localasap.packageName = paramasap.packageName;
    localasap.iconUrl = paramasap.iconUrl;
    localasap.length = paramasap.length;
    localasap.name = paramasap.name;
    localasap.progress = paramasap.progress;
    localasap.state = paramasap.state;
    localasap.cDH = paramasap.cDH;
    localasap.kx = paramasap.kx;
    localasap.pageId = paramasap.pageId;
    localasap.via = paramasap.via;
    return localasap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pageId=" + this.pageId);
    localStringBuilder.append("\nmoduleId=" + this.kx);
    localStringBuilder.append("\npositionId=" + this.cDH);
    localStringBuilder.append("\nvia=" + this.via);
    localStringBuilder.append("\nurl=" + this.url);
    localStringBuilder.append("\npackageName=" + this.packageName);
    localStringBuilder.append("\niconUrl=" + this.iconUrl);
    localStringBuilder.append("\nlength=" + this.length);
    localStringBuilder.append("\nname=" + this.name);
    localStringBuilder.append("\nprogress=" + this.progress);
    localStringBuilder.append("\nstate=" + this.state);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asap
 * JD-Core Version:    0.7.0.1
 */