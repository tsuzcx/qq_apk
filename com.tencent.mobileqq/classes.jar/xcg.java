import org.json.JSONObject;

public class xcg
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public xcg(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("iconGrid");
    this.c = paramJSONObject.optString("jumpUrl");
    this.d = paramJSONObject.optString("iconLoveGrid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */