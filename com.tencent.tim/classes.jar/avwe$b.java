import android.text.TextUtils;

public class avwe$b
{
  private long aAB;
  private avwe.a b;
  private String cOl = "";
  private String cOm;
  private int eyT;
  private String kx;
  private String mainVersion;
  private String md5 = "";
  private String url;
  private String version;
  
  public b a(int paramInt)
  {
    this.eyT = paramInt;
    return this;
  }
  
  public b a(long paramLong)
  {
    this.aAB = paramLong;
    return this;
  }
  
  public b a(String paramString)
  {
    this.kx = paramString;
    return this;
  }
  
  public b b(String paramString)
  {
    this.version = paramString;
    return this;
  }
  
  public avwe.a c()
  {
    if (TextUtils.isEmpty(this.kx)) {
      throw new IllegalArgumentException("moduleId can not be null");
    }
    return new avwe.a(this.kx, this.version, this.mainVersion, this.url, this.md5, this.cOl, this.cOm, this.eyT, this.aAB, this.b);
  }
  
  public b c(String paramString)
  {
    this.mainVersion = paramString;
    return this;
  }
  
  public b d(String paramString)
  {
    this.url = paramString;
    return this;
  }
  
  public b e(String paramString)
  {
    this.md5 = paramString;
    return this;
  }
  
  public b f(String paramString)
  {
    this.cOl = paramString;
    return this;
  }
  
  public b g(String paramString)
  {
    this.cOm = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avwe.b
 * JD-Core Version:    0.7.0.1
 */