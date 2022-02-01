import org.json.JSONObject;

public class zte
{
  public String a;
  public String b;
  
  public zte(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zte
 * JD-Core Version:    0.7.0.1
 */