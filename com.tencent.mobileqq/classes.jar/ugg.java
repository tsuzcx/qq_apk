import org.json.JSONObject;

public class ugg
  extends ugc
{
  public boolean a;
  
  public ugg(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static ugg a(JSONObject paramJSONObject)
  {
    return new ugg(paramJSONObject);
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
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */