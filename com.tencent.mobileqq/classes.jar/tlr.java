import org.json.JSONObject;

public class tlr
{
  public double a;
  public int a;
  public long a;
  public String a;
  public double b;
  public int b;
  public long b;
  public String b;
  public double c;
  public long c;
  public String c;
  public double d;
  
  public static tlr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      tlr localtlr = new tlr();
      try
      {
        localtlr.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localtlr.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localtlr.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localtlr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localtlr.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localtlr.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localtlr.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localtlr.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localtlr.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localtlr.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localtlr.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localtlr.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localtlr;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localtlr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlr
 * JD-Core Version:    0.7.0.1
 */