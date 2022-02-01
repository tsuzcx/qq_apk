import org.json.JSONObject;

public class umx
  extends umt
{
  public boolean a;
  
  public umx(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static umx a(JSONObject paramJSONObject)
  {
    return new umx(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optBoolean("isImmediatelyUpload");
      return;
    }
    this.a = false;
  }
  
  public String toString()
  {
    return "WeSeeBeaconReportConfigInfo{mIsImmediatelyUpload=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umx
 * JD-Core Version:    0.7.0.1
 */