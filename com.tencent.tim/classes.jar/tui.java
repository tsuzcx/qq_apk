import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

public class tui
  implements tve.a<PointF>
{
  public static final tui a = new tui();
  
  public PointF a(Object paramObject, float paramFloat)
  {
    if ((paramObject instanceof JSONArray)) {
      return tws.a((JSONArray)paramObject, paramFloat);
    }
    if ((paramObject instanceof JSONObject)) {
      return tws.a((JSONObject)paramObject, paramFloat);
    }
    throw new IllegalArgumentException("Unable to parse point from " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tui
 * JD-Core Version:    0.7.0.1
 */