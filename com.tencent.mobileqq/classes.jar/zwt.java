import org.json.JSONObject;

public class zwt
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static zwt a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      zwt localzwt = new zwt();
      paramString = new JSONObject(paramString);
      localzwt.a = paramString.optString("icon_image_url", "");
      localzwt.b = paramString.optString("md5", "");
      localzwt.c = paramString.optString("widget_id", "");
      return localzwt;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "k = icon_image_url, value = " + this.a + "\n k = md5, value = " + this.b + "\n k = widget_id, value = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwt
 * JD-Core Version:    0.7.0.1
 */