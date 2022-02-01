import android.text.TextUtils;

public class afib
{
  public String eId;
  public String epId;
  public String flag;
  public String md5;
  public String random;
  public String resid;
  public String uin;
  public String ver;
  
  public afib(String paramString)
  {
    this.resid = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length >= 7)
      {
        this.uin = paramString[0];
        this.random = paramString[1];
        this.ver = paramString[2];
        this.flag = paramString[3];
        this.md5 = paramString[4];
        this.epId = paramString[5];
        this.eId = paramString[6];
      }
    }
  }
  
  public boolean ajo()
  {
    return this.resid.split("_").length >= 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afib
 * JD-Core Version:    0.7.0.1
 */