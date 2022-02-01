import org.json.JSONObject;

public class spu
{
  private String aFA = "";
  private String aFB = "";
  private String md5 = "";
  
  public static spu a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      spu localspu = new spu();
      paramString = new JSONObject(paramString);
      localspu.aFA = paramString.optString("icon_image_url", "");
      localspu.md5 = paramString.optString("md5", "");
      localspu.aFB = paramString.optString("widget_id", "");
      return localspu;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String getDownloadUrl()
  {
    return this.aFA;
  }
  
  public String getID()
  {
    return this.aFB;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String toString()
  {
    return "k = icon_image_url, value = " + this.aFA + "\n k = md5, value = " + this.md5 + "\n k = widget_id, value = " + this.aFB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spu
 * JD-Core Version:    0.7.0.1
 */