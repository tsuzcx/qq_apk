import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

public class tws
{
  public static float a(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Double)) {
      return ((Double)paramObject).floatValue();
    }
    if ((paramObject instanceof JSONArray)) {
      return (float)((JSONArray)paramObject).optDouble(0);
    }
    return 0.0F;
  }
  
  public static PointF a(JSONArray paramJSONArray, float paramFloat)
  {
    if (paramJSONArray.length() < 2) {
      throw new IllegalArgumentException("Unable to parse point for " + paramJSONArray);
    }
    return new PointF((float)paramJSONArray.optDouble(0, 1.0D) * paramFloat, (float)paramJSONArray.optDouble(1, 1.0D) * paramFloat);
  }
  
  public static PointF a(JSONObject paramJSONObject, float paramFloat)
  {
    return new PointF(a(paramJSONObject.opt("x")) * paramFloat, a(paramJSONObject.opt("y")) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tws
 * JD-Core Version:    0.7.0.1
 */