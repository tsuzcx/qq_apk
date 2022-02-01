import org.json.JSONObject;

public class trh
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
  
  public static trh a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      trh localtrh = new trh();
      try
      {
        localtrh.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localtrh.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localtrh.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localtrh.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localtrh.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localtrh.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localtrh.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localtrh.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localtrh.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localtrh.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localtrh.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localtrh.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localtrh;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localtrh;
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
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */