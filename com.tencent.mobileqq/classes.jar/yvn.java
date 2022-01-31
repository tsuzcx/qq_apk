import org.json.JSONObject;

public class yvn
{
  public String a;
  public String b;
  
  public yvn(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvn
 * JD-Core Version:    0.7.0.1
 */