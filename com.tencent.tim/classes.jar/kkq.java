import org.json.JSONObject;

public class kkq
{
  public int aJq;
  public int aJr;
  public double aP;
  public double aQ;
  public double aR;
  public double aS;
  public String aab;
  public String aac;
  public String aad;
  public long si;
  public long sj;
  public long sk;
  
  public static kkq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      kkq localkkq = new kkq();
      try
      {
        localkkq.aJq = paramJSONObject.optInt("showGesturesAdType");
        localkkq.si = paramJSONObject.optLong("showGesturesAd_beginTime");
        localkkq.sj = paramJSONObject.optLong("showGesturesAd_endTime");
        localkkq.aab = paramJSONObject.optString("DragGoods");
        localkkq.aP = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localkkq.aQ = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localkkq.aR = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localkkq.aS = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localkkq.aac = paramJSONObject.optString("LongPressColor");
        localkkq.sk = paramJSONObject.optLong("LongPressTime");
        localkkq.aad = paramJSONObject.optString("slideColor");
        localkkq.aJr = paramJSONObject.optInt("validSlideLength");
        return localkkq;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localkkq;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramJSONObject = null;
      }
    }
    localException1.printStackTrace();
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkq
 * JD-Core Version:    0.7.0.1
 */