import org.json.JSONException;
import org.json.JSONObject;

public class yuv
{
  public long KL;
  public long KM;
  public long KN;
  public int cbr;
  public int version = -1;
  
  public static yuv a(String paramString)
  {
    yuv localyuv = new yuv();
    try
    {
      paramString = new JSONObject(paramString);
      localyuv.version = paramString.optInt("version", -1);
      localyuv.KL = paramString.optLong("showDate", 0L);
      localyuv.KM = paramString.optInt("leftShowNum", 0);
      localyuv.cbr = paramString.optInt("showCountEveryDay", 0);
      localyuv.KN = paramString.optInt("leftLoginNum", 0);
      return localyuv;
    }
    catch (Exception paramString)
    {
      localyuv.version = -1;
    }
    return localyuv;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.version);
      localJSONObject.put("showDate", this.KL);
      localJSONObject.put("leftShowNum", this.KM);
      localJSONObject.put("showCountEveryDay", this.cbr);
      localJSONObject.put("leftLoginNum", this.KN);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MobileUnityVersionInfo [version=" + this.version + ", showDate=" + this.KL + ", leftShowNum=" + this.KM + ", leftLoginNum = " + this.KN + ", showCountEveryDay=" + this.cbr + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuv
 * JD-Core Version:    0.7.0.1
 */