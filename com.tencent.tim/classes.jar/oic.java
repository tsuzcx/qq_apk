import org.json.JSONObject;

public class oic
  extends ohx
{
  public String aqd;
  
  public oic(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static oic a(JSONObject paramJSONObject)
  {
    return new oic(paramJSONObject);
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.aqd = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oic
 * JD-Core Version:    0.7.0.1
 */