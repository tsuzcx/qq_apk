import java.util.HashMap;

public class acuo
{
  private static String TAG = "JumpParserResult";
  private String bqV;
  private String bqW;
  private HashMap<String, String> jn;
  private String mAction;
  private String mScheme;
  private String mUrl;
  
  public acuo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    paramString3 = paramString4;
    if (paramString4 == null) {
      paramString3 = "";
    }
    this.mScheme = str;
    this.bqV = paramString1;
    this.mAction = paramString2;
    this.bqW = paramString3;
    this.mUrl = paramString5;
    this.jn = new HashMap();
  }
  
  public void Gf(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.bqV = str;
  }
  
  public void fj(String paramString1, String paramString2)
  {
    if (this.jn == null) {
      return;
    }
    this.jn.put(paramString1, paramString2);
  }
  
  public String getAction()
  {
    return this.mAction;
  }
  
  public String getScheme()
  {
    return this.mScheme;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public String rW()
  {
    return this.bqV;
  }
  
  public void setAction(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mAction = str;
  }
  
  public void setScheme(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mScheme = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuo
 * JD-Core Version:    0.7.0.1
 */