import org.json.JSONObject;

public class sps
{
  private String aFA = "";
  private JSONObject config = new JSONObject();
  private String md5 = "";
  
  public static sps a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      sps localsps = new sps();
      paramString = new JSONObject(paramString);
      localsps.aFA = paramString.optString("icon_image_url", "");
      localsps.config = paramString.optJSONObject("config");
      localsps.md5 = paramString.optString("md5", "");
      return localsps;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public JSONObject R()
  {
    return this.config;
  }
  
  public String getDownloadUrl()
  {
    return this.aFA;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String toString()
  {
    return "k = icon_image_url, value = " + this.aFA + "\n k = config, value = " + this.config.toString() + "\n k = md5, value = " + this.md5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */