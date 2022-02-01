public class asbr
{
  public String appId;
  public String appName;
  public String cEf;
  public String channel;
  public String pkgName;
  
  public asbr(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.appId = paramString1;
    this.appName = paramString2;
    this.channel = paramString3;
    this.pkgName = paramString4;
    this.cEf = paramString5;
  }
  
  public String toString()
  {
    return " appId=" + this.appId + ",appName=" + this.appName + ",pkgName=" + this.pkgName + ",channel=" + this.channel + ",defUrl=" + this.cEf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbr
 * JD-Core Version:    0.7.0.1
 */