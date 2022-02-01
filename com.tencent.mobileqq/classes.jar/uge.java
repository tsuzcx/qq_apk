import org.json.JSONObject;

public class uge
  extends uga
{
  public boolean a;
  
  public uge(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static uge a(JSONObject paramJSONObject)
  {
    return new uge(paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uge
 * JD-Core Version:    0.7.0.1
 */