import org.json.JSONObject;

public class ufs
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
  
  public static ufs a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      ufs localufs = new ufs();
      try
      {
        localufs.jdField_a_of_type_Int = paramJSONObject.optInt("showGesturesAdType");
        localufs.jdField_a_of_type_Long = paramJSONObject.optLong("showGesturesAd_beginTime");
        localufs.jdField_b_of_type_Long = paramJSONObject.optLong("showGesturesAd_endTime");
        localufs.jdField_a_of_type_JavaLangString = paramJSONObject.optString("DragGoods");
        localufs.jdField_a_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateH");
        localufs.jdField_b_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateW");
        localufs.jdField_c_of_type_Double = paramJSONObject.optDouble("DragGoodsCoordinateX");
        localufs.d = paramJSONObject.optDouble("DragGoodsCoordinateY");
        localufs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("LongPressColor");
        localufs.jdField_c_of_type_Long = paramJSONObject.optLong("LongPressTime");
        localufs.jdField_c_of_type_JavaLangString = paramJSONObject.optString("slideColor");
        localufs.jdField_b_of_type_Int = paramJSONObject.optInt("validSlideLength");
        return localufs;
      }
      catch (Exception localException1)
      {
        paramJSONObject = localufs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufs
 * JD-Core Version:    0.7.0.1
 */