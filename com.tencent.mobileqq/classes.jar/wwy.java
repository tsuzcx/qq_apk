import org.json.JSONObject;

public class wwy
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static wwy a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      wwy localwwy = new wwy();
      paramString = new JSONObject(paramString);
      localwwy.a = paramString.optString("icon_image_url", "");
      localwwy.b = paramString.optString("md5", "");
      localwwy.c = paramString.optString("widget_id", "");
      return localwwy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wwy
 * JD-Core Version:    0.7.0.1
 */